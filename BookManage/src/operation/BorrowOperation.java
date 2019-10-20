package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅书籍!");
        System.out.println("请输入要借阅的书籍的id: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();

        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (!book.getId().equals(id)) {
                continue;
            }
            if (book.isBorrow()) {
                System.out.println("此书已经被借走了!");
                break;
            }
            book.setBorrow(true);
            System.out.println("借阅成功");
        }
    }
}
