package FuckingBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode129 {

//    public int sumNumbers(TreeNode root) {
//        if (root == null){
//            return 0;
//        }
//        return dfs(root, 0);
//    }
//    public int dfs(TreeNode root, int preSum){
//        if (root.left == null && root.right == null){
//            return root.val + preSum*10;
//        }
//        int lSum = 0, rSum = 0;
//        if (root.left != null){
//            lSum = dfs(root.left, root.val + preSum*10);
//        }
//        if (root.right != null){
//            rSum = dfs(root.right, root.val + preSum*10);
//        }
//        return lSum+rSum;
//    }

    public int sumNumbers(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        int res = 0;

        if (root == null){
            return res;
        }

        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<List<Integer>> queuePath = new LinkedList<>();

        List<Integer> rootPath = new ArrayList<>();
        rootPath.add(root.val);
        queueNode.offer(root);
        queuePath.offer(rootPath);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            List<Integer> path = queuePath.poll();

            if (node.left == null && node.right == null) {
                ans.add(path);
            }

            if (node.left != null) {
                List<Integer> temp = new ArrayList<>(path);
                temp.add(node.left.val);

                queueNode.offer(node.left);
                queuePath.offer(temp);
            }

            if (node.right != null) {
                List<Integer> temp = new ArrayList<>(path);
                temp.add(node.right.val);

                queueNode.offer(node.right);
                queuePath.offer(temp);
            }

        }

        for (int i = 0; i < ans.size(); i++){
            String temp = "";
            for (int j = 0; j < ans.get(i).size(); j++){
                temp += ans.get(i).get(j);
            }

            res += Integer.parseInt(temp);
        }

        return res;

    }
}
