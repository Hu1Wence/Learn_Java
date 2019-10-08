class DListNode {
    public int val = 0;
    public DListNode prev = null;
    public DListNode next = null;

    public DListNode(int val) {
        this.val = val;
    }
}

public class DLinkedList {
    public DListNode head = null;

    public void addFirst(int data) {
        DListNode node = new DListNode(data);

        node.next = head.next;
        node.prev = head;

        head.prev = node.next;
        head.next = node;
    }
}
