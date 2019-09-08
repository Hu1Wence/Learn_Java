public class NumSum {
    public static void main(String[] args) {
        int i = 1;
        double sum = 0.0;
        int flag = 1;
        for (i = 1; i <= 100; i++) {
            sum = sum + (1.0 / i) * flag;
            flag = -flag;
        }
        System.out.println(sum);
    }
}