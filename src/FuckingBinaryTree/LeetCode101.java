package FuckingBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class LeetCode101 {
    public static void main(String[] args) {
        //isSymmetric
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);

        node1.right = node2;
        node1.left = node3;
        node2.left = node6;
        node2.right = node4;
        node3.left = node5;
        node3.right = node7;

        System.out.println(new LeetCode101().isSymmetric(node1));
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetricWithQueue(root);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left)
                && left.val == right.val;
    }

    private boolean isSymmetricWithQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode1 = queue.poll();
            TreeNode tempNode2 = queue.poll();

            if (tempNode1 == null && tempNode2 == null) {
                continue;
            }

            if (tempNode1 == null || tempNode2 == null) {
                return false;
            }

            if (tempNode1.val != tempNode2.val) {
                return false;
            }

            queue.offer(tempNode1.left);
            queue.offer(tempNode2.right);

            queue.offer(tempNode1.right);
            queue.offer(tempNode2.left);
        }

        return true;
    }
}
