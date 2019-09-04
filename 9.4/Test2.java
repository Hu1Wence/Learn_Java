public class Test2 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = 0;
        for (a = 1; a <= 9; a += 1) {
            for (b = 1; b <= a; b += 1) {
                c = a * b;
                System.out.printf("%d * %d = %d ", a, b, c);
            }
            System.out.printf("\n");
        }
    }
}