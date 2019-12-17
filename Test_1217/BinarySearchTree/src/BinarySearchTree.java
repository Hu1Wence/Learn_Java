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

    public Node root = null;

    //1.增加元素
    public boolean add(int key, int value) {
        Node node = new Node(key, value);
        if (root == null) {
            //如果root等于null直接返回
            root = node;
            return true;
        }

        //parent 为保存 cur 的父亲节点
        Node parent = null;
        //cur 是要取寻找合适位置的节点
        Node cur = root;
        while (cur != null) {
            //parent 和 cur 要同时更新
            parent = cur;
            //如果要添加的元素的 key 大于 cur 节点的 key 就去右边找，
            //小于去左边找，
            //等于就修改value的值并返回，map中的 key 相同会覆盖之前的value
            if (key > cur.key) {
                cur = cur.right;
            } else if (key < cur.key) {
                cur = cur.left;
            } else {
                cur.value = value;
                return true;
            }
        }

        //循环结束时，cur 一定是 null
        //parent 保存着 cur 的父亲节点
        //如果是key 大于 parent 的 key 就在 parent 右边添加新的 node
        //否则在左边添加， 不可能等于，等于就已经在上面的循环返回了
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
            //如果是根节点是 null 就返回
            return;
        }
        //parent 为保存 cur 的父亲节点
        Node parent = null;
        //cur 是要取寻找要删除的节点
        Node cur = root;

        //循环结束时有两种可能
        //1。 cur 为 null 代表节点不存在
        //2。 cur 的 key 和 目标 key 相等 说明找到了
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

        //判断一下是不是因为没找到而结束的循环
        //如果是就直接返回，代表删除失败
        if (cur == null) {
            return;
        }

        //1. cur.left == null
        //    1) cur 是 root，则 root = cur.right
        //    2) cur 不是 root，cur 是 parent.left，
        //       则 parent.left = cur.right
        //    3) cur 不是 root，cur 是 parent.right，
        //       则 parent.right = cur.right
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else if (cur == parent.right) {
                parent.right = cur.right;
            }
        }
        //2. cur.right == null
        //    1) cur 是 root，则 root = cur.left
        //    2) cur 不是 root，cur 是 parent.left，
        //    则 parent.left = cur.left
        //    3) cur 不是 root，cur 是 parent.right，
        //    则 parent.right = cur.left
        if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (cur == parent.left) {
                parent.left = cur.left;
            } else if (cur == parent.right) {
                parent.right = cur.left;
            }
        }

        //3. cur.left != null && cur.right != null
        //    需要使用替换法进行删除，即在它的右子树中寻找中序下的第一个结点(关键码最小)，
        //    用它的值填补到被删除节点中，再来处理该结点的删除问题
        if (cur.left != null && cur.right != null) {
            //prev 是用来保存 node 的父亲节点
            Node prev = cur;
            //node 是用来寻找 prev 的右子树中，最左的节点
            Node node = prev.right;
            //循环结束，node 一定是 prev 的右子树中最左的节点
            while (node.left != null) {
                prev = node;
                node = node.left;
            }

            //如果 node 的 key 大于 parent 的 key，说明 node 在 parent 的右边
            //所以要把右边的节点替换掉置为null
            //如果 node 的 key 小于 parent 的 key，说明 node 在 parent 的左边
            //所以要把左边的节点替换掉置为null
            if (node.key > prev.key) {
                prev.right = null;
            } else if (node.key < prev.key) {
                prev.left = null;
            }

            //然或将cur 的 key 替换成 node 的 key
            //然或将cur 的 value 替换成 node 的 value
            cur.key = node.key;
            cur.value = node.value;
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

    public void prevOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.key + " ");
        prevOrder(root.left);
        prevOrder(root.right);
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.key + " ");
        inOrder(root.right);
    }

}
