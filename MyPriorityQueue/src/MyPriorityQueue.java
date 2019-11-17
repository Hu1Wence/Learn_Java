import java.util.ArrayList;
import java.util.List;

public class MyPriorityQueue {
    private int[] array = new int[100];
    private int size = 0;

    public void offer(int x) {
        if (size >= array.length) {
            return;
        }
        array[size] = x;
        size++;
        shiftUp(array, size - 1);
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = parent * 2 + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                swap(array, parent, child);
            } else {
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }

    private static void shiftUp(int[] array, int index) {
        int child = index;
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (array[parent] < array[child]) {
                swap(array, parent, child);
            }else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int ret = array[0];
        array[0] = array[size - 1];
        size--;
        shiftDown(array, size, 0);
        return ret;
    }
    private static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[0];
    }

    public static void main(String[] args) {
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
        myPriorityQueue.offer(9);
        myPriorityQueue.offer(5);
        myPriorityQueue.offer(2);
        myPriorityQueue.offer(7);
        myPriorityQueue.offer(3);
        myPriorityQueue.offer(8);
        while (myPriorityQueue.peek() != null) {
            int a = myPriorityQueue.poll();
            System.out.print(a + " ");
        }
    }
}