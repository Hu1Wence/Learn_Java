import book.BookList;
import user.Admin;
import user.NormalUser;
import user.User;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();
        while (true) {
            int choice = user.menu();
            user.doOperation(choice, bookList);
        }
    }

    public static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎来到图书管理系统!");
        System.out.println("请输入您的姓名: ");
        String name = scanner.next();
        System.out.println("请输入您的用户选项: 1 -> 管理员  2 -> 普通用户");
        int role = scanner.nextInt();
        if (role == 1) {
            return new Admin(name);
        } else {
            return new NormalUser(name);
        }
    }


}
