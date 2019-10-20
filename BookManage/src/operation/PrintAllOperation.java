package operation;

import book.BookList;

public class PrintAllOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        for (int i = 0; i < bookList.getSize(); i++) {
            System.out.println(bookList.getBook(i));
        }
        System.out.println("共有 " + bookList.getSize() + " 本书籍");
    }
}
