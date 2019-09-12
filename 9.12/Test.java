import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //使用 Scanner 读取字符串/整数/浮点数
        // Scanner sc = new Scanner(System.in);
        // System.out.println("请输入您的姓名: ");
        // String name = sc.nextLine();
        // System.out.println("请输入您的年龄: ");
        // int age = sc.nextInt();
        // System.out.println("请输入您的工资: ");
        // double salary = sc.nextDouble();
        // System.out.println("您的姓名是 -> " + name);
        // System.out.println("您的年龄是 -> " + age);
        // System.out.println("您的工资是 -> "+ salary);
        //sc.close();
        //使用 Scanner 循环读取 N 个数字
        //读取 10 个数字,并把它们 +1 输出
        Scanner sc = new Scanner(System.in);
        int[] arr =  new int[10];
        System.out.println("请输入十个数字: ");
        for (int i = 0; i < 10; i++) {
            int num = sc.nextInt();
            arr[i] = num + 1;
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}