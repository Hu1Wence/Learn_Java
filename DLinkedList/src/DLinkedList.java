class DLinkedNode {
    public int val = 0;
    public DLinkedNode prev = null;
    public DLinkedNode next = null;

    public DLinkedNode(int val) {
        this.val = val;
    }
}

public class DLinkedList {
    private DLinkedNode head = null;

    //创建傀儡节点
    public DLinkedList() {
        head = new DLinkedNode(-1);

        head.prev = head;
        head.next = head;
    }

    //加在第一个位置
    public void addFirst(int data) {
        DLinkedNode newNode = new DLinkedNode(data);

        newNode.next = head.next;
        newNode.prev = head;

        head.next.prev = newNode;
        head.next = newNode;
    }

    //加在最后一个位置
    public void addLast(int data) {
        DLinkedNode newNode = new DLinkedNode(data);

        newNode.prev = head.prev;
        newNode.next = head;

        head.prev.next = newNode;
        head.prev = newNode;
    }

    //任意位置插入
    public void addIndex(int index, int data) {
        DLinkedNode newNode = new DLinkedNode(data);

        DLinkedNode Node = head.next;
        for (int i = 0; i < index; i++) {
            Node = Node.next;
        }

        newNode.next = Node;
        newNode.prev = Node.prev;

        Node.prev.next = newNode;
        Node.prev = newNode;
    }

    //删除第一次出现关键字key的节点
    public void remove(int key) {
        DLinkedNode node;
        for (node = head.next; node != head; node = node.next) {
            if (node.val == key) {
                break;
            }
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    //删除所有关键字为key的节点
    public void removeAll(int key) {
        DLinkedNode node = head.next;
        while (node != head) {
            if (node.val == key) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node = node.next;
        }
    }

    //得到链表长度
    public int size() {
        int size = 0;
        for (DLinkedNode node = head.next; node != head; node = node.next) {
            size++;
        }
        return size;
    }

    //清空链表
    public void clearAll() {
        DLinkedNode newHead = new DLinkedNode(-1);

        newHead.next = newHead;
        newHead.prev = newHead;
        head = newHead;
    }

    public void disPlay() {
        //正向
        System.out.println("正向");
        System.out.print("[");
        for (DLinkedNode node = head.next; node != head; node = node.next) {
            System.out.print(node.val);
            if (node.next != head) {
                System.out.print(",");
            }
        }
        System.out.println("]");

        //反向
        System.out.println("反向");
        System.out.print("[");
        for (DLinkedNode node = head.prev; node != head; node = node.prev) {
            System.out.print(node.val);
            if (node.prev != head) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

}
