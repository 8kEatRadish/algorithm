package FuckingBinaryTree;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode222 {
    public static void main(String[] args) {

    }
    //dfs
//    public int countNodes(TreeNode root) {
//        if (root == null){
//            return 0;
//        }
//
//        int left = countNodes(root.left);
//        int right = countNodes(root.right);
//
//        return left + right + 1;
//    }

    /**
     * 方法一：二分查找 + 位运算
     * 对于任意二叉树，都可以通过广度优先搜索或深度优先搜索计算节点个数，时间复杂度和空间复杂度都是 O(n)O(n)，其中 nn 是二叉树的节点个数。这道题规定了给出的是完全二叉树，因此可以利用完全二叉树的特性计算节点个数。
     *
     * 规定根节点位于第 00 层，完全二叉树的最大层数为 hh。根据完全二叉树的特性可知，完全二叉树的最左边的节点一定位于最底层，因此从根节点出发，每次访问左子节点，直到遇到叶子节点，该叶子节点即为完全二叉树的最左边的节点，经过的路径长度即为最大层数 hh。
     *
     * 当 0 \le i < h0≤i<h 时，第 ii 层包含 2^i2
     * i
     *   个节点，最底层包含的节点数最少为 11，最多为 2^h2
     * h
     *  。
     *
     * 当最底层包含 11 个节点时，完全二叉树的节点个数是
     *
     * \sum_{i=0}^{h-1}2^i+1=2^h
     * i=0
     * ∑
     * h−1
     * ​
     *  2
     * i
     *  +1=2
     * h
     *
     *
     * 当最底层包含 2^h2
     * h
     *   个节点时，完全二叉树的节点个数是
     *
     * \sum_{i=0}^{h}2^i=2^{h+1}-1
     * i=0
     * ∑
     * h
     * ​
     *  2
     * i
     *  =2
     * h+1
     *  −1
     *
     * 因此对于最大层数为 hh 的完全二叉树，节点个数一定在 [2^h,2^{h+1}-1][2
     * h
     *  ,2
     * h+1
     *  −1] 的范围内，可以在该范围内通过二分查找的方式得到完全二叉树的节点个数。
     *
     * 具体做法是，根据节点个数范围的上下界得到当前需要判断的节点个数 kk，如果第 kk 个节点存在，则节点个数一定大于或等于 kk，如果第 kk 个节点不存在，则节点个数一定小于 kk，由此可以将查找的范围缩小一半，直到得到节点个数。
     *
     * 如何判断第 kk 个节点是否存在呢？如果第 kk 个节点位于第 hh 层，则 kk 的二进制表示包含 h+1h+1 位，其中最高位是 11，其余各位从高到低表示从根节点到第 kk 个节点的路径，00 表示移动到左子节点，11 表示移动到右子节点。通过位运算得到第 kk 个节点对应的路径，判断该路径对应的节点是否存在，即可判断第 kk 个节点是否存在。
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}
