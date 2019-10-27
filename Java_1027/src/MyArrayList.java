public class MyArrayList {
    private Object[]  array;
    private int  size;

    //尾插
    public void add(Object o) {
        array[size] = o;
        size++;
    }

    //获取 index位置的元素
    public Object get(int index) {
        return array[index];
    }

    public static void main(String[] args) {
        MyArrayList books = new MyArrayList();
        for (int i =  0; i <  10; i++) {
            books.add(new Book());
        }
        MyArrayList people = new MyArrayList();
        for (int  i = 0; i < 10; i++) {
            people.add(new Person());
        }
    }
}
