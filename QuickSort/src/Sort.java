import java.util.Arrays;

public class Sort {
    public static void quickSort(int[] array) {
        quickSortHoare(array, 0, array.length - 1);
    }

    private static void quickSortHoare(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(array, left, right);
        quickSortHoare(array, left, index - 1);
        quickSortHoare(array, index + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int index = array[right];
        while (i < j) {
            while (i < j && array[i] <= index) {
                i++;
            }
            while (i < j && array[j] >= index) {
                j--;
            }
            swap(array, i, j);
        }
        swap(array, right, i);
        return i;
    }
    private static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 5 ,2 ,7 ,3, 8, 1, 4};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
