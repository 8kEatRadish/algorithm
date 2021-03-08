package FuckingBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode107 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        //忘了加这句导致npe，我是傻逼
        if (root == null) {
            return res;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {

            int len = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                level.add(node.val);
            }
            res.add(0, level);
        }
        return res;

    }
}
