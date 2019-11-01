package MyQueue;

public class MyQueue2 {
    private int[] array = new int[100];
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    //入队列
    public void offer(int val) {
        if (size == array.length) {
            System.out.println("队列已满,插入失败");
            return;
        }
        array[tail] = val;
        tail++;
        if (tail == array.length) {
            tail = 0;
        }
        size++;
    }

    //出队列
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        Integer ret = array[head];
        head++;
        if (head == array.length) {
            head = 0;
        }
        size--;
        return ret;
    }

    //取队首元素
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[head];
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
