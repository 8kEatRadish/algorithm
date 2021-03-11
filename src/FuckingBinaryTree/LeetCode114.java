package FuckingBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode114 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        new LeetCode114().flatten(node1);
    }
    List<TreeNode> treeNodes = new ArrayList<>();

    public void flatten(TreeNode root) {
        helper(root);
        if (treeNodes.size() == 0 || treeNodes.size() == 1) {
            return;
        }
        for (int i = 1; i < treeNodes.size(); i++) {
            treeNodes.get(i - 1).left = null;
            treeNodes.get(i - 1).right = treeNodes.get(i);
        }

    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        treeNodes.add(root);
        helper(root.left);
        helper(root.right);
    }
}
