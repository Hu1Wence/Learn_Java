public class TestDLinkedList {
    public static void main(String[] args) {
        testAddFirst();
        testAddLast();
        testAddIndex();
        testRemove();
        testRemoveAll();
        testSize();
        testClearAll();
    }
    public static void testAddFirst() {
        System.out.println("测试addFirst");
        DLinkedList dLinkedList = new DLinkedList();
        dLinkedList.addFirst(1);
        dLinkedList.addFirst(2);
        dLinkedList.addFirst(3);
        dLinkedList.addFirst(4);
        dLinkedList.addFirst(5);
        dLinkedList.disPlay();
    }

    public static void testAddLast() {
        System.out.println("测试addLast");
        DLinkedList dLinkedList = new DLinkedList();
        dLinkedList.addLast(1);
        dLinkedList.addLast(2);
        dLinkedList.addLast(3);
        dLinkedList.addLast(4);
        dLinkedList.addLast(5);
        dLinkedList.disPlay();
    }

    public static void testAddIndex() {
        System.out.println("测试addIndex,在2节点位置增加7");
        DLinkedList dLinkedList = new DLinkedList();
        dLinkedList.addLast(0);
        dLinkedList.addLast(1);
        dLinkedList.addLast(2);
        dLinkedList.addLast(3);
        dLinkedList.addLast(4);
        dLinkedList.addLast(5);
        dLinkedList.addIndex(2, 7);
        dLinkedList.disPlay();
    }

    public static void testRemove() {
        System.out.println("测试Remove,把第一次出现7的节点删除");
        DLinkedList dLinkedList = new DLinkedList();
        dLinkedList.addLast(0);
        dLinkedList.addLast(1);
        dLinkedList.addLast(2);
        dLinkedList.addLast(3);
        dLinkedList.addLast(4);
        dLinkedList.addLast(5);
        dLinkedList.addIndex(2, 7);
        dLinkedList.addIndex(5, 7);
        dLinkedList.disPlay();
        dLinkedList.remove(7);
        dLinkedList.disPlay();
    }

    public static void testRemoveAll() {
        System.out.println("测试删除所有节点值为7的节点");
        DLinkedList dLinkedList = new DLinkedList();
        dLinkedList.addLast(0);
        dLinkedList.addLast(1);
        dLinkedList.addLast(2);
        dLinkedList.addLast(3);
        dLinkedList.addLast(4);
        dLinkedList.addLast(5);
        dLinkedList.addIndex(2, 7);
        dLinkedList.addIndex(5, 7);
        dLinkedList.disPlay();
        dLinkedList.removeAll(7);
        dLinkedList.disPlay();
    }

    public static void testSize() {
        System.out.println("测试链表长度");
        DLinkedList dLinkedList = new DLinkedList();
        dLinkedList.addLast(0);
        dLinkedList.addLast(1);
        dLinkedList.addLast(2);
        dLinkedList.addLast(3);
        dLinkedList.addLast(4);
        dLinkedList.addLast(5);
        dLinkedList.addIndex(2, 7);
        dLinkedList.addIndex(5, 7);
        System.out.println("链表长度为:" + dLinkedList.size());
        dLinkedList.disPlay();
        dLinkedList.removeAll(7);
        dLinkedList.disPlay();
    }

    public static void testClearAll() {
        System.out.println("测试清空链表");
        DLinkedList dLinkedList = new DLinkedList();
        dLinkedList.addLast(0);
        dLinkedList.addLast(1);
        dLinkedList.addLast(2);
        dLinkedList.disPlay();
        dLinkedList.clearAll();
        System.out.println("链表长度为:" + dLinkedList.size());
        dLinkedList.disPlay();
    }
}
