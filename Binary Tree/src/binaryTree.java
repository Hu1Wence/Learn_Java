class Node  {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}
public class binaryTree {
    private static Node root;

    //建立一个二叉树
    public static Node treeBuild() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = F;
        E.right = G;
        C.right = H;
        return A;
    }

    //前序遍历
    public static void preOrderTraversal(Node root) {
        if (root == null) {
            //如果节点为 null 直接返回
            return;
        }

        //非空情况
        //先访问节点，再递归左树，再递归又树
        System.out.print(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //中序遍历
    public static void inOrderTraversal(Node root) {
        if (root == null) {
            //如果节点为 null 直接返回
            return;
        }

        //非空情况
        //先遍历左树节点，在访问节点，再遍历又树节点
        inOrderTraversal(root.left);
        System.out.print(root.val);
        inOrderTraversal(root.right);
    }

    //后序遍历
    public static void postOrderTraversal(Node root) {
        if (root == null) {
            //如果节点为 null 直接返回
            return;
        }

        //非空情况
        //先遍历左树节点和右树节点，然后再访问节点
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val);
    }

    //求节点个数
    public static int size(Node root) {
        if (root == null) {
            //空节点情况
            return 0;
        } else if (root.left == null && root.right == null) {
            //叶节点情况
            return 1;
        }

        //左树节点个数 + 右树节点个数 + 根节点
        return 1 + size(root.left) + size(root.right);
    }

    //求叶节点个数
    public static int leafSize(Node root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }

        return leafSize(root.left) + leafSize(root.right);
    }

    //求第 k 层节点个数
    public static int getKLevelSize(Node root, int k) {
//        if (k < 1 || root == null) {
//            return 0;
//        }
//        if (k == 1) {
//            return 1;
//        }
//
//        return getKLevelSize(root.left, k - 1)
//                + getKLevelSize(root.right, k - 1);












        if (k < 1 || root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelSize(root.left, k - 1) + getKLevelSize(root.right, k - 1);
    }

    public static Node find(Node root, char toFind) {
        if (root.)
        if (root.val == toFind) {
            return root;
        }
    }
    public static void main(String[] args) {
        root = treeBuild();
        //测试前序遍历
        System.out.print("测试前序遍历: ");
        preOrderTraversal(root);
        System.out.println();
        //测试中序遍历
        System.out.print("测试中序遍历: ");
        inOrderTraversal(root);
        System.out.println();
        //测试后序遍历
        System.out.print("测试后序遍历: ");
        postOrderTraversal(root);
        System.out.println();
        //测试求节点个数
        System.out.println("节点个数为: " + size(root));
        //测试叶节点个数
        System.out.println("叶节点个数为: " + leafSize(root));
        //测试求第 k 层节点个数
        System.out.println("第 3 层节点个数: " + getKLevelSize(root, 3));
    }
}
