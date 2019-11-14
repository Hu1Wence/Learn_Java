import java.util.PriorityQueue;

public class MyPriorityQueue {
    public static void creatHeap(int[] array, int size) {
        for (int i = (size - 1) / 2; i >= 0; i--) {
            shiftDown(array, size, i);
        }
    }

    public static void shiftDown(int[] array, int size, int index) {
        int left = 2 * index + 1;
        while (left < size) {
            int min = left;
            int right = 2 * index + 2;
            if (right < size) {
                if (array[right] < array[left]) {
                    min = right;
                }
            }
            if (array[index] <= array[min]) {
                break;
            }
            int t = array[index];
            array[index] = array[min];
            array[min] = t;
            index = min;
            left = 2 * index + 1;
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8, 1};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i : array) {
            priorityQueue.offer(i);
        }
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll() + " ");
        }
    }
}
