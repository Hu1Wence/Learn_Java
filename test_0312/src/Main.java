import java.util.ArrayList;

public class Main {

    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0 ; i < B.length; i++) {
            int count = 1;
            for (int j = i ; j < A.length; j++) {
                count = count * A[j];
            }
            B[i] = count;
        }
        return B;
    }
}