import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] array)  {
        mergeSortHelper(array, 0, array.length);
    }
    private static void mergeSortHelper(int[] array, int left, int right) {
        if (left >= right || right - left == 1) {
            return;
        }

        int mid = (right + left) / 2;

        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid, right);
        merge(array, left, mid, right);
    }
    private static void merge(int[] array, int left, int mid, int right) {
        int length = right - left;
        int tempIndex = 0;
        int[] tempValue = new int[length];
        int i = left;
        int j = mid;
        while (i < mid && j < right) {
            if (array[i] < array[j]) {
                tempValue[tempIndex++] = array[i++];
            } else {
                tempValue[tempIndex++] = array[j++];
            }
        }

        while (i < mid) {
            tempValue[tempIndex++] = array[i++];
        }
        while (j < right) {
            tempValue[tempIndex++] = array[j++];
        }

        for (int k = 0; k < length; k++) {
            array[k + left] = tempValue[k];
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 5, 8};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

}
