public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.testAddFirst();
        test.testAddLast();
        test.testAddIndex();
        test.testremove();
        test.testremoveall();
    }

    LinkedList linkedList = new LinkedList();

    public void testAddFirst() {
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(5);
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        linkedList.display();
    }
    public void testAddLast() {
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.display();
    }
    public void testAddIndex() {
        linkedList.addIndex(3, 9);
        linkedList.addIndex(5, 7);
        linkedList.addIndex(7, 10);
        linkedList.display();
    }
    public void testremove() {
        linkedList.remove(3);
        linkedList.display();
    }
    public void testremoveall() {
        linkedList.removeAll(5);
        linkedList.display();
    }
}
