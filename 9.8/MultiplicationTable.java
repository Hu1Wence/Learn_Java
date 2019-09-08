public class MultiplicationTable {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        for (a = 1; a <= 9 ; a++) {
            for (b = 1; b <= a; b++) {
                System.out.print(a + " * " + b + " = " + a * b + "  ");
            }
            System.out.print("\n");
        }
    }
}