import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        //初始化一个密码
        String my_password = new String("hu123456");
        Scanner sc = new Scanner(System.in);
        //记录输入次数
        int count = 0;
        System.out.println("请输入密码: ");
        for (count = 0; count < 3; count++) {
            String string = sc.nextLine();
            if (my_password.equals(string)) {
                System.out.println("登录成功！");
            } else if (!(my_password.equals(string)) && count <= 1) {
                System.out.println("密码错误，请重新输入！");
            } else if (!(my_password.equals(string)) && count == 2) {
                System.out.println("连续三次错误，程序退出！");
            }
        }
        sc.close();
    }
}