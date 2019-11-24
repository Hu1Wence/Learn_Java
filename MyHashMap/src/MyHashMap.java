public class MyHashMap {
    public class Node {
        public int key;
        public int value;

        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 11;
    private Node[] array = new Node[capacity];

    public void put(int key, int value) {
        int hash = key % capacity;
        Node node = new Node(key, value);
        if (array[hash] == null) {
            array[hash] = node;
            return;
        }

        node.next = array[hash];
        array[hash] = node;
    }

    public Integer get(int key) {
        int hash = key & capacity;
        for (Node node = array[hash]; node != null; node = node.next) {
            if (node.key == key) {
                return node.value;
            }
        }
        return null;
    }

    public boolean Remove(int key) {
        int hash = key % capacity;
        for (Node node = array[hash]; node != null; node = node.next) {
            if (node.next.key == key) {
                node.next = node.next.next;
                return true;
            }
        }
        return false;
    }

    
}
