package book;

public class Book {
    private String name;
    private String id;
    private String author;
    private String type;
    private int price;
    private boolean isBorrow;

    public Book(String name, String id, String author, String type, int price, boolean isBorrow) {
        this.name = name;
        this.id = id;
        this.author = author;
        this.type = type;
        this.price = price;
        this.isBorrow = isBorrow;
    }

    public String getId() {
        return id;
    }

    public boolean isBorrow() {
        return isBorrow;
    }

    public void setBorrow(boolean borrow) {
        isBorrow = borrow;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", isBorrow=" + isBorrow +
                '}';
    }
}
