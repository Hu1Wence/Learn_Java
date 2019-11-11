import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test1 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }

        TreeNode left = Convert(pRootOfTree.left);
        TreeNode leftTail = left;
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }

        if (left != null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }

        TreeNode right = Convert(pRootOfTree.right);
        if (right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }

        return left == null ? pRootOfTree : left;
    }

    public String tree2str(TreeNode t) {
        StringBuilder stringBuilder = new StringBuilder();
        doTree2str(t, stringBuilder);
        return stringBuilder.toString();
    }

    private void doTree2str(TreeNode t, StringBuilder stringBuilder) {
        if (t == null) {
            return;
        }
        if (t != null) {
            stringBuilder.append(t.val);
        }
        if (t.left != null || t.right != null) {
            stringBuilder.append('(');
            doTree2str(t.left, stringBuilder);
            stringBuilder.append(')');
            if (t.right != null) {
                stringBuilder.append('(');
                doTree2str(t.right, stringBuilder);
                stringBuilder.append(')');
            }
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            if (stack.isEmpty()) {
                break;
            }

            TreeNode node = stack.pop();
            result.add(node.val);
            cur = node.right;
        }
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;

        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            if (stack.isEmpty()) {
                break;
            }

            TreeNode node = stack.peek();
            if (node.right == null || prev == node.right) {
                result.add(node.val);
                stack.pop();
                prev = node;

            } else {
                cur  = node.right;
            }
        }
        return result;
    }
}
