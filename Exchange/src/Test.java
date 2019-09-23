import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Exchange change = new Exchange();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要交换的两个数:");
        change.num1 = sc.nextDouble();
        change.num2 = sc.nextDouble();
        change.exchange();
        sc.close();
    }
}
