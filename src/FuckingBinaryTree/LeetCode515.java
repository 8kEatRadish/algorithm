package FuckingBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 您需要在二叉树的每一行中找到最大的值。
 */
public class LeetCode515 {

    //无fuck可讲，直接层级遍历干翻
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int maxInt = Integer.MIN_VALUE;

            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                maxInt = Math.max(maxInt, node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(maxInt);
        }
        return ans;
    }
}
