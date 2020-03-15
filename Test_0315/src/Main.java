import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            BigInteger b1 = new BigInteger(str1);
            BigInteger b2 = new BigInteger(str2);
            System.out.println(b1.add(b2));
        }
    }
}