import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = partition(array, left, right);
        quickSortHelper(array, left, mid - 1);
        quickSortHelper(array, mid + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int index = right;
        while (left < right) {
            while (left < right && array[left] <= array[index]) {
                left++;
            }
            while (left < right && array[right] >= index) {
                right--;
            }
            swap(array, left, right);
        }
        swap(array, left, index);
        return left;
    }

    private static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 5, 8};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

}
