package FuckingBinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 隋宏伟
 * @Date 2021-02-28
 * @description 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 **/
public class LeetCode105 {

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        Map<Integer, Integer> inMap = new HashMap();

        for (int i = 0; i < inLen; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preLen - 1, inMap, 0, inLen - 1);
    }

    /**
     *
     *       [前序遍历]
     *       =        =======================================         ==========================
     *   preStart   preStart + 1         [inRoot - inStart + preStart]                          preEnd
     *
     *       [中序遍历]
     *       =======================================         =         ==========================
     *   inStart                            inRoot - 1     inRoot    inRoot + 1                 inEnd
     *
     *   设 前序遍历 左子树右边 下标为x
     *
     *   x - preStart - 1 = inRoot - 1 - inStart
     *
     *   x = inRoot - inStart + preStart
     *
     *
     * @param preorder
     * @param preStart
     * @param preEnd
     * @param inMap
     * @param inStart
     * @param inEnd
     * @return
     */
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, Map<Integer, Integer> inMap, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        //前序遍历
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);

        root.left = buildTree(preorder, preStart + 1, inRoot - inStart + preStart, inMap, inStart, inRoot - 1);
        root.right = buildTree(preorder, inRoot - inStart + preStart + 1, preEnd, inMap, inRoot + 1, inEnd);
        return root;
    }
}
