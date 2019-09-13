import java.util.Scanner;

public class Test9_13 {
    public static void main(String[] args) {
        //输入年龄、生日、电话号码
        long[] arr = new long[3];
        Scanner sc = new Scanner(System.in);
        long num;
        int i = 0;
        System.out.println("输入年龄、生日、电话号码: ");
        for (i = 0; i < 3; i++) {
            num = sc.nextLong();
            arr[i] = num;
        }
        System.out.println("年龄为 -> " + arr[0]);
        System.out.println("生日为 -> " + arr[1]);
        System.out.println("电话号码为 -> " + arr[2]);
        sc.close();
    }
}