package FuckingBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class LeetCode257 {

    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        if (root == null){
            return ans;
        }

        helper(root, new StringBuffer());

        return ans;
    }

    private void helper(TreeNode root, StringBuffer s) {
        if (root == null){
            return;
        }
        s.append(root.val);
        if (root.left == null && root.right == null) {
            ans.add(s.toString());
            return;
        }

        s.append("->");

        helper(root.left, new StringBuffer(s));
        helper(root.right, new StringBuffer(s));
    }
}
