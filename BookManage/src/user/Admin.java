package user;

import book.BookList;
import operation.*;

import java.util.Scanner;

public class Admin extends User{
    public Admin(String name) {
        super(name);
        operations = new IOperation[] {
                new ExitOperation(),
                new AddBookOperation(),
                new DeleteBookOperation(),
                new FindOperation(),
                new PrintAllOperation(),
        };
    }

    @Override
    public int menu() {
        System.out.println("============");
        System.out.println("hello " + name);
        System.out.println("1. 增加书籍");
        System.out.println("2. 删除书籍");
        System.out.println("3. 查找书籍");
        System.out.println("4. 打印所有信息");
        System.out.println("0. 退出");
        System.out.println("============");
        System.out.println("请输入您的选择: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }


}
