import java.util.Arrays;

public class Sort {
    public static void bubbleSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = array.length - 1; cur > bound; cur--) {
                if (array[cur] < array[cur - 1]) {
                    int temp = array[cur];
                    array[cur] = array[cur - 1];
                    array[cur - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 3, 6, 8, 1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
