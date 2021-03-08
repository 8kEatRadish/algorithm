package FuckingBinaryTree;

import java.util.HashMap;
import java.util.Map;

public class LeetCode106 {
    public static void main(String[] args) {

    }

    Map<Integer, Integer> inMap = new HashMap<>();
    int post_end = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int postLen = postorder.length;
        int inLen = inorder.length;

        post_end = postLen - 1;
        for (int i = 0; i < inLen; i++) {
            inMap.put(inorder[i], i);
        }
        return help(postorder, 0, postLen - 1);
    }

    private TreeNode help(int[] postorder, int left, int right) {

        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[post_end]);
        int inRoot = inMap.get(root.val);

        post_end--;

        root.right = help(postorder, inRoot + 1, right);
        root.left = help(postorder, left, inRoot - 1);

        return root;
    }

}
