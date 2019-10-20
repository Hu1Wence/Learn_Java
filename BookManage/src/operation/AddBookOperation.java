package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class AddBookOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("新增一本书籍!");
        System.out.println("请输入新增书籍的书名: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("请输入新增书籍的id: ");
        String id = scanner.next();
        System.out.println("请输入新增书籍的作者: ");
        String author = scanner.next();
        System.out.println("请输入新增书籍的类型: ");
        String type = scanner.next();
        System.out.println("请输入新增书籍的价格: ");
        int price = scanner.nextInt();
        Book book = new Book(name, id, author, type, price, false);
        bookList.setBooks(bookList.getSize(), book);
        bookList.setSize(bookList.getSize() + 1);
    }
}
