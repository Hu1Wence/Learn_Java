public class GreatestCommonDivisors {
    public static void main(String[] args) {
        int num1 = 90;
        int num2 = 41;
        int i = 0;
        int gcd = 0;
        int check = num1;
        if (num1 > num2) {
            check = num2;
        }
        for (i = 1; i <= check; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }
        System.out.println(gcd);
    }
}