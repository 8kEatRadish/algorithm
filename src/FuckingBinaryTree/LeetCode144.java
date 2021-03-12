package FuckingBinaryTree;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class LeetCode144 {

//    //递归实现
//    List<Integer> ans = new ArrayList<>();
//    public List<Integer> preorderTraversal(TreeNode root) {
//        helper(root);
//        return ans;
//    }
//
//    private void helper(TreeNode root) {
//        if (root ==null){
//            return;
//        }
//
//        ans.add(root.val);
//        helper(root.left);
//        helper(root.right);
//
//    }

//    //描述递归的迭代
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//
//        if (root == null){
//            return ans;
//        }
//
//        Stack<TreeNode> queue = new Stack<>();
//        TreeNode node = root;
//        while (!queue.isEmpty() || node != null) {
//            while (node != null){
//                ans.add(node.val);
//                queue.push(node);
//                node = node.left;
//            }
//            node = queue.pop();
//            node = node.right;
//        }
//
//        return ans;
//    }

    //morris遍历，没有理解
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        TreeNode p1 = root, p2 = null;

        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    res.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                }
            } else {
                res.add(p1.val);
            }
            p1 = p1.right;
        }
        return res;
    }

}
