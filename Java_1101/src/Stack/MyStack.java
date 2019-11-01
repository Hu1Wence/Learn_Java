package Stack;

public class MyStack {
    private int[] array = new int[100];
    private int size = 0;

    //压栈
    public void push(int val) {
        array[size] = val;
        size++;
    }

    //出栈
    public Integer pop() {
        if (size == 0) {
            return null;
        }
        int ret = array[size - 1];
        size--;
        return ret;
    }

    //查看栈顶元素
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[size - 1];
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //查看栈的大小
    public int size() {
        return size;
    }
}
