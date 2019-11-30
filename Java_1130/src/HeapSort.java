import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] array) {
        creatHeap(array);
        for (int i = 0; i < array.length; i++) {
            swap(array, 0, array.length - 1 - i);
            shiftDown(array, array.length - 1 - i, 0);
        }
    }

    private static void creatHeap(int[] array) {
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = index * 2 + 1;
        while (child < size) {
            if (child + 1 < size && array[child] < array[child + 1]) {
                child = child + 1;
            }

            if (array[parent] < array[child]) {
                swap(array, parent, child);
            } else {
                break;
            }

            parent = child;
            child = parent * 2 + 1;
        }
    }

    private static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 5, 8};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
