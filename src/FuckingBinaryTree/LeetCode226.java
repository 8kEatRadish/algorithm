package FuckingBinaryTree;

/**
 * 翻转一棵二叉树。
 */
public class LeetCode226 {
    //很简单
    public TreeNode invertTree(TreeNode root) {
        if (root != null){
            TreeNode node = root.left;
            root.left = root.right;
            root.right = node;

            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
