class LinkedNode {
    public int data = 0;
    public LinkedNode next = null;

    public LinkedNode(int data) {
        this.data = data;
    }
}
public class LinkedList {
    //创建一个头节点
    public LinkedNode head = null;

    //头插
    public void addFirst(int elem) {
        LinkedNode node = new LinkedNode(elem);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    //尾插
    public void addLast(int elem) {
      LinkedNode node = new LinkedNode(elem);
      if (head == null) {
          head = node;
          return;
      }
      LinkedNode cur = head;
      while (cur.next != null) {
          cur = cur.next;
      }
      cur.next = node;
    }

    //展示链表
    public void display() {
        System.out.print("[");
        for (LinkedNode node = head;
             node != null; node = node.next) {
            System.out.print(node.data);
            if (node.next != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    //指定位置添加元素
    public void addIndex(int index, int elem) {
        LinkedNode node = new LinkedNode(elem);
        int len = size();
        if (index < 0 || index > len) {
            return;
        }
        if (index == 0) {
            addFirst(elem);
        } else if (index == len) {
            addLast(elem);
        }
        LinkedNode prve = getIndex(index - 1);
        node.next = prve.next;
        prve.next = node;
    }


    private LinkedNode getIndex(int index) {
        LinkedNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //  获取当前链表有多是元素
    public int size() {
        int size = 0;
        for (LinkedNode node = head;
             node != null; node = node.next) {
            size++;
        }
        return size;
    }

    //判断链表中key关键字是否存在链表中
    public boolean contains(int key) {
        for (LinkedNode node = head;
             node != null; node = node.next) {
            if (node.data == key) {
                return true;
            }
        }
        return false;
    }

    //删除第一次出现关键字key的节点
    public void remove(int key) {
        //空链表
        if (head == null) {
            return;
        } else if (head.data == key) {
            head = head.next;
            return;
        }
        LinkedNode prve = searchPrve(key);
        prve.next = prve.next.next;
    }

    //删除链表中所有指定元素
    public void removeAll(int key) {
        if (head == null) {
            return;
        }
        while (head.data == key) {
            //如果删除元素在链表头部
            if (head.next == null) {
                return;
            }
            head = head.next;
        }
        LinkedNode prve = searchPrve(key);
        while (prve != null) {
            if (prve.next.next == null) {
                //删除元素在最后
                prve.next = null;
                return;
            } else {
                prve.next = prve.next.next;
                prve = searchPrve(key);
            }
        }
    }

    //获得要删除链表的上一个节点
    private LinkedNode searchPrve(int key) {
        for (LinkedNode node = head;
        node != null; node = node.next) {
            if (node.next.data == key) {
                return node;
            }
        }
        return null;
    }
}