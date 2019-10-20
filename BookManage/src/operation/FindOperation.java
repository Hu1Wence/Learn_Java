package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class FindOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("查找书籍!");
        System.out.println("请输入要查找书籍的书名: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int count = 0;
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                System.out.println(book);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("没找到此书籍!");
        } else {
            System.out.println("共找到 " + count + " 本相同书籍!");
        }
    }
}
