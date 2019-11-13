import java.util.Arrays;

public class Test1 {
    //插入排序
    public static void insertSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            int temp = array[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if (array[cur] > temp) {
                    array[cur + 1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + 1] = temp;
        }
    }

    //希尔排序
    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            insertSortGap(array, gap);
            gap /= 2;
        }
        insertSortGap(array, 1);
    }

    public static void insertSortGap(int[] array, int gap) {
        for (int bound = 0; bound < array.length; bound++) {
            int temp = array[bound];
            int cur = bound - gap;
            for (; cur >= 0; cur -= gap) {
                if (array[cur] > temp) {
                    array[cur + gap] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + gap] = temp;
        }
    }

    //选择排序
    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[bound] > array[cur]) {
                    swap(array, bound, cur);
                }
            }
        }
    }

    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8, 1};
        //insertSort(array);
        //shellSort(array);
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}