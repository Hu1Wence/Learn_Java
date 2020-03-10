import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            BigInteger num = new BigInteger(String.valueOf(1));
            int count = 0;
            for (int i = 1; i <= n; i++) {
                num = num.multiply(new BigInteger(String.valueOf(i)));
            }
            String s = String.valueOf(num);
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '0') {
                    count++;
                } else {
                    break;
                }
            }
            System.out.println(count);
        }

    }

}