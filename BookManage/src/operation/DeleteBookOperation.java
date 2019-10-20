package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class DeleteBookOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("删除书籍!");
        System.out.println("请输入您想要删除书籍的id: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (book.getId().equals(id)) {
                break;
            }
        }
        if (i >= bookList.getSize()) {
            System.out.println("未找到要找的书籍!");
            return;
        }

        Book lastBook = bookList.getBook(bookList.getSize() - 1);
        bookList.setBooks(i, lastBook);
        bookList.setSize(bookList.getSize() - 1);
        System.out.println("删除成功!");
    }
}
