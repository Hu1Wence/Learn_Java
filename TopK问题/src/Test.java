import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int[] array = new int[]{9, 5, 2, 7, 1, 3, 8, 6};
        for (int i = 0; i < 3; i++) {
            priorityQueue.offer(array[i]);
        }
        for (int i = 3; i < array.length; i++) {
            if (priorityQueue.peek() < array[i]) {
                priorityQueue.poll();
                priorityQueue.offer(array[i]);
            }
        }
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll() + " ");
        }
    }
}
