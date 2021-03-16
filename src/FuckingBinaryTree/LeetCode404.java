package FuckingBinaryTree;

/**
 *
 计算给定二叉树的所有左叶子之和。
 */
public class LeetCode404 {

    int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }

        if (root.left != null && root.left.left == null && root.left.right == null){
            ans += root.left.val;
        }

        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);

        return ans;
    }
}
