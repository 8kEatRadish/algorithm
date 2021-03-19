package FuckingBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * <p>
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 */
public class LeetCode503 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = new TreeNode();
        while (!queue.isEmpty()) {
            node = queue.poll();

            //先右后左返回底层最左边的节点
            if (node.right != null) {
                queue.offer(node.right);
            }

            if (node.left != null) {
                queue.offer(node.left);
            }
        }
        return node.val;
    }
}
