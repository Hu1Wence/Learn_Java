class ListNode {
    ListNode next;
    int val;

    public ListNode(int val) {
        this.val = val;
    }
}
public class MyStack2 {
    ListNode head = null;
    ListNode tail = null;
    int size = 0;

    //入栈
    public void push(int val) {
        ListNode node = new ListNode(val);
        //空栈的情况
        if (size == 0) {
            head = node;
            tail = node;
            size++;
            return;
        }
        //非空栈的情况
        tail.next = node;
        tail = tail.next;
        size++;
        return;
    }

    //出栈
    public Integer pop() {
        //空栈的情况;
        if (size == 0) {
            return null;
        }
        Integer ret = tail.val;
        ListNode node = head;

        //寻找到tail节点的上一个节点
        for (int i = 0; i < size - 2; i++) {
            node = node.next;
        }
        tail = node;
        size--;
        if (size == 0) {
            head = null;
            tail = head;
        }
        return ret;
    }

    //查看栈顶元素
    public Integer peek() {
        //空栈的情况;
        if (size == 0) {
            return null;
        }
        return tail.val;
    }

    //查看是否是空栈
    public boolean isEmpty() {
        return size == 0;
    }

    //查看栈的大小
    public int size() {
        return size;
    }
}
