import java.util.Arrays;

public class Test_9_15 {
    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7};
        isSorted(arr);
        System.out.println(Arrays.toString(arr));
    }    
    public static void isSorted(int[] arr) {
        for (int bound = 0; bound < arr.length; bound++) {
            for (int cur = arr.length - 1; cur > bound; cur--) {
                if (arr[cur - 1] > arr[cur]) {
                    int tmp = arr[cur - 1];
                    arr[cur - 1] = arr[cur];
                    arr[cur] = tmp;
                }
            }
        }
    }
}
