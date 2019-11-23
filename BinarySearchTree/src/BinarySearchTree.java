public class BinarySearchTree {
    public static class Node {
        public int key;
        public int value;
        public Node left;
        public Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root = null;

    //1.增加元素
    public boolean add(int key, int value) {
        Node node = new Node(key, value);
        if (root == null) {
            root = node;
            return true;
        }

        Node parent = null;
        Node cur = root;
        while (cur != null) {
            parent = cur;
            if (key > cur.key) {
                cur = cur.right;
            } else if (key < cur.key) {
                cur = cur.left;
            } else {
                cur.value = value;
                return true;
            }
        }
        if (key > parent.key) {
            parent.right = node;
        } else {
            parent.left = node;
        }
        return true;
    }
    //2.删除元素
    public void Remove(int key) {
        if (root == null) {
            return;
        }
        Node parent = null;
        Node cur = root;
        while (cur != null) {
            if (key > cur.key) {
                parent = cur;
                cur = cur.right;
            } else if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else {
                break;
            }

        }

        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else if (cur == parent.right) {
                parent.right = cur.right;
            }
        }



    }

    //3.查找元素
    public Integer searchKey(int key) {
        if (root == null) {
            return null;
        }

        Node node = root;
        while (node != null) {
            if (key > node.key) {
                node = node.right;
            } else if (key < node.key) {
                node = node.left;
            } else {
                return node.value;
            }
        }
        return null;
    }


}
