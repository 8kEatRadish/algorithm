package FuckingBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null){
            return ans;
        }

        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<List<Integer>> queuePath = new LinkedList<>();

        List<Integer> rootPath = new ArrayList<>();
        rootPath.add(root.val);
        queueNode.offer(root);
        queuePath.offer(rootPath);

        while (!queueNode.isEmpty()){
            TreeNode node = queueNode.poll();
            List<Integer> path = queuePath.poll();

            if (node.left == null && node.right == null){
                int sum = path.stream().mapToInt(i -> i).sum();
                if (sum == targetSum){
                    ans.add(path);
                }
            }

            if (node.left != null){
                List<Integer> temp = new ArrayList<>(path);
                temp.add(node.left.val);

                queueNode.offer(node.left);
                queuePath.offer(temp);
            }

            if (node.right != null){
                List<Integer> temp = new ArrayList<>(path);
                temp.add(node.right.val);

                queueNode.offer(node.right);
                queuePath.offer(temp);
            }

        }

        return ans;
    }
}
