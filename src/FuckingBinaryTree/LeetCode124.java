package FuckingBinaryTree;

/**
 * @Author 隋宏伟
 * @Date 2021-02-28
 * @description 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LeetCode124 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        LeetCode124 leetCode124 = new LeetCode124();

        System.out.println("最大路径和是：" + leetCode124.maxPathSum(node1));

    }

    //记录结果
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        oneSideMax(root);
        return ans;
    }

    public int oneSideMax(TreeNode root){
        //设定递归边界
        if (root == null) return 0;

        //防止节点出现负数
        int left = Integer.max(0,oneSideMax(root.left));
        int right = Integer.max(0,oneSideMax(root.right));

        //路径结果取最大值，可以防止父节点为负数
        ans = Integer.max(ans,left + right + root.val);

        return Integer.max(left,right) + root.val;
    }

}