package FuckingBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class LeetCode102 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int n = queue.size();

            for (int i = 0; i< n; i++){
                if (queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }

                if (queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }

                level.add(queue.poll().val);
            }
            ans.add(level);
        }
        return ans;
    }
}
