import java.util.Arrays;
import java.util.HashMap;

public class Test {
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            while (i < j && !isOdd(A[i])) {
                i++;
            }
            while (i < j && isOdd(A[j])) {
                j--;
            }
            swap(A, i, j);
            i++;
            j--;
        }
        return A;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static boolean isOdd(int a) {
        return a % 2 != 0;
    }
    
}

