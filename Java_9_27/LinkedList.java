import com.sun.org.apache.bcel.internal.generic.LNEG;

class LinkedNode {
    public int data = 0;
    public LinkedNode next = null;

    public LinkedNode(int data) {
        this.data = data;
    }
}

public class LinkedList {
    // 链表的头结点(第一个节点). 有了这个头结点之后
    // 就可以根据 next 把所有的剩下的元素都获取到
    private LinkedNode head = null;

    public void addFirst(int elem) {
        LinkedNode node = new LinkedNode(elem);
        if (this.head == null) {
            // 如果是空链表
            this.head = node;
            return;
        }
        // 非空的情况
        node.next = head.next;
        head = node;
        return;
    }

    public void addLast(int elem) {
        LinkedNode node = new LinkedNode(elem);
        if (this.head == null) {
            this.head = node;
            return;
        }
        LinkedNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        // 循环结束之后, cur 就已经指向最后一个节点了
        // 新节点插入到 cur 之后即可
        cur.next = node;
    }

    public void addIndex(int index, int elem) {
        LinkedNode node = new LinkedNode(elem);
        int len = size();
        if(index < 0 || index > len){
            return;
        }
        if(index == 0){
            addFirst(elem);
            return;
        }
        if(index == len){
            addLast(elem);
            return;
        }
        LinkedNode prev = getIndexPos(index-1);
        node.next = prev.next;
        prev.next = node;
    }

    private LinkedNode getIndexPos(int index) {
        // 是否要判定一下 index 是在有效范围中呢?
        LinkedNode cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public int size() {
        int size = 0;
        for (LinkedNode cur = this.head;
            cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    public boolean contains(int toFind) {
        // 直接遍历链表, 依次比较每个元素就行了
        for (LinkedNode cur = this.head;
                cur != null; cur = cur.next) {
            if (cur.data == toFind) {
                return true;
            }
        }
        return false;
    }

    public void remove(int toRemove) {
        // 1. 先单独处理下空链表的情况
        if (head == null) {
            return;
        }
        // 2. 先考虑是否要删除的是头结点
        if (head.data == toRemove) {
            this.head = this.head.next;
            return;
        }
        // 3. 删除中间的节点, 找到要删除元素的前一个元素
        LinkedNode prev = searchPrev(toRemove);
        if (prev == null) {
            return;
        }
        // prev.next = prev.next.next;  // 这种写法虽然没错, 但是比较抽象
        LinkedNode nodeToRemove = prev.next;
        prev.next = nodeToRemove.next;
    }

    public void removeAllKey(int toRemove) {
        if (head == null) {
            return;
        }
        // 先处理后续的节点, 最后处理头结点的情况
        LinkedNode prev = head;
        LinkedNode cur = head.next;
        while (cur != null) {
            if (cur.data == toRemove) {
                // cur 对应的节点就应该删掉
                prev.next = cur.next;  // 删除 cur 指向的节点
                cur = prev.next; // 让 cur 继续指向 prev 的下一个节点
            } else {
                // cur 对应的节点不用删除
                prev = cur;
                cur = cur.next;
            }
        }
        // 头结点的情况
        if (this.head.data == toRemove) {
            this.head = this.head.next;
        }
        return;
    }

    private LinkedNode searchPrev(int toRemove) {
        // 找到要删除元素的前一个位置
        if (this.head == null) {
            return null;
        }
        LinkedNode prev = this.head;
        while (prev.next != null) {
            if (prev.next.data == toRemove) {
                return prev;
            }
            prev = prev.next;
        }
        // 返回 null 表示没找到
        return null;
    }

    public void display() {
        // 打印链表中的所有元素
        System.out.print("[");
        for (LinkedNode node = this.head;
            node != null; node = node.next) {
            System.out.print(node.data);
            if (node.next != null) {
                // 如果不是最后一个元素就加上 , 否则不加
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void clear() {
        // Java 垃圾回收, 后续的所有节点, 只要这个节点
        // 没有引用指向它, 就会被 JVM 判定成垃圾.
        // 就会被自动回收掉
        this.head = null;
    }
}
