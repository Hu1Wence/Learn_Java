package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("归还书籍!");
        System.out.println("请输入要归还书籍的id: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        int i = 0;
        for ( ; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (!book.getId().equals(id)) {
                continue;
            }
            if (!book.isBorrow()) {
                System.out.println("这本书未借出去,归还失败!");
            }
            book.setBorrow(false);
        }
    }
}
