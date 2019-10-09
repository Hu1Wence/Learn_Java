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

    public void disPlay() {
        //正向
        System.out.print("[");
        for (DLinkedNode node = head.next; node != head; node = node.next) {
            System.out.print(node.val);
            if (node.next != head) {
                System.out.print(",");
            }
        }
        System.out.println("]");

        //反向
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
