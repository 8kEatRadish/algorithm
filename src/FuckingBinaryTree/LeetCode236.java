package FuckingBinaryTree;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }

        if (root != null) {
            TreeNode lNode = lowestCommonAncestor(root.left, p, q);
            TreeNode rNode = lowestCommonAncestor(root.right, p, q);

            if (lNode != null && rNode != null) {
                return root;
            } else if (lNode == null) {
                return rNode;//两个节点都在右孩子
            } else {
                return lNode;//两个节点都在左孩子
            }
        }

        return null;
    }
}
