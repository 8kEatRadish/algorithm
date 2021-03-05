package FuckingBinaryTree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class LeetCode94 {

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.right = node2;
        node2.left = node3;

        System.out.println(Arrays.toString(new LeetCode94().inorderTraversal(node1).toArray()));

    }

    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();

        buildInorderTraversal(ans,root);

        return ans;
    }

    private void buildInorderTraversal(ArrayList<Integer> ans, TreeNode root) {
        if (root == null) return;

        buildInorderTraversal(ans,root.left);
        ans.add(root.val);
        buildInorderTraversal(ans,root.right);
    }
}
