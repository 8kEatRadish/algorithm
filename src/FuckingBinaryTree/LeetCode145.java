package FuckingBinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 */
public class LeetCode145 {

//    //递归
//    List<Integer> ans = new ArrayList<>();
//    public List<Integer> postorderTraversal(TreeNode root) {
//        helper(root);
//        return ans;
//    }
//
//    private void helper(TreeNode root) {
//        if (root == null){
//            return;
//        }
//
//        helper(root.left);
//        helper(root.right);
//        ans.add(root.val);
//    }

    //描述递归过程
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root, pre = null;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();

            if (node.right == null || node.right == pre) {
                ans.add(node.val);
                pre = node;
                node = null;
            } else {
                stack.push(node);
                node = node.right;
            }
        }
        return ans;
    }
}
