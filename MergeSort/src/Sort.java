import java.util.Arrays;

public class Sort {
    public static void mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length);
    }

    private static void mergeSortHelper(int[] array, int left, int right) {
        if (left >= right || right - left == 1) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int length = right - left;
        int[] temp = new int[length];
        int tempIndex = 0;
        int i = left;
        int j = mid;
        while (i < mid && j < right) {
            if (array[i] <= array[j]) {
                temp[tempIndex++] = array[i++];
            }else {
                temp[tempIndex++] = array[j++];
            }
        }
        while (i < mid) {
            temp[tempIndex++] = array[i++];
        }
        while (j < right) {
            temp[tempIndex++] = array[j++];
        }

        for (int k = 0; k < length; k++) {
            array[left + k] = temp[k];
        }
    }
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 3, 6, 1, 8};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
