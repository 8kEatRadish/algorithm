package FuckingBinaryTree;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
public class LeetCode543 {

    //直接深度遍历干翻
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        //计算边的个数，不是节点的个数
        max = Math.max(max,left + right);

        return Math.max(left,right) + 1;
    }
}
