package MyQueue;

class ListNode {
    ListNode next;
    int val;

    public ListNode(int val) {
        this.val = val;
    }
}

public class MyQueue {
    private ListNode head = null;
    private ListNode tail = null;
    private int size = 0;

    //入队列
    public void offer(int val) {
        ListNode node = new ListNode(val);
        if (size == 0) {
            head = node;
            tail = node;
            size++;
            return;
        }
        tail.next = node;
        tail = tail.next;
        size++;
    }

    //出队列
    public Integer poll() {
        if (head == null) {
            return null;
        }
        Integer ret = head.val;
        head = head.next;
        if (head == null) {
            tail = head;
        }
        size--;
        return ret;
    }

    //队首元素
    public Integer peek() {
        if (head == null) {
            return null;
        }
        Integer ret = head.val;
        return ret;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //查看队列大小
    public int size() {
        return size;
    }
}
