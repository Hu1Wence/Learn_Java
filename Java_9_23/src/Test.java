import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入两个数字:");
        calculator.num1 = sc.nextDouble();
        calculator.num2 = sc.nextDouble();
        calculator.add();
        calculator.sub();
        calculator.mul();
        calculator.div();
    }
}
