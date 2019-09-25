class LinkedNode {
    public int data = 0;
    public LinkedNode next = null;

    public LinkedNode(int data) {
        this.data = data;
    }
}
public class LinkedList {
    //创建一个头节点
    public LinkedNode head = null;

    //头插
    public void addFirst(int elem) {
        LinkedNode node = new LinkedNode(elem);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    //尾插
    public void addLast(int elem) {
      LinkedNode node = new LinkedNode(elem);
      if (head == null) {
          head = node;
          return;
      }
      LinkedNode cur = head;
      while (cur.next != null) {
          cur = cur.next;
      }
      cur.next = node;
    }

    public void display() {
        System.out.print("[");
        for (LinkedNode node = head;
             node != null; node = node.next) {
            System.out.print(node.data);
            if (node.next != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void addIndex(int index, int elem) {
        LinkedNode node = new LinkedNode(elem);
        int len = size();
        if (index < 0 || index > len) {
            return;
        }
        if (index == 0) {
            addFirst(elem);
        } else if (index == len) {
            addLast(elem);
        }
        LinkedNode prve = getIndex(index - 1);
        node.next = prve.next;
        prve.next = node;
    }

    private LinkedNode getIndex(int index) {
        LinkedNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public int size() {
        int size = 0;
        for (LinkedNode node = head;
             node != null; node = node.next) {
            size++;
        }
        return size;
    }

}