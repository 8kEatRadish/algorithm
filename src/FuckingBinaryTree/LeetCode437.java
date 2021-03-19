package FuckingBinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode437 {

    //key为前缀和，value为个数
    Map<Integer, Integer> prefixMap = new HashMap<>();
    int target;

    public int pathSum(TreeNode root, int sum) {
        target = sum;
        prefixMap.put(0, 1);
        return recur(root, 0);
    }

    private int recur(TreeNode root, int curSum) {
        //递归停止条件
        if (root == null) {
            return 0;
        }

        //本层个数结果结果
        int res = 0;

        //本层路径
        curSum += root.val;

        //查找是否有符合的路径
        res += prefixMap.getOrDefault(curSum - target, 0);

        //更新本层的路径
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1);

        //进入下一层
        int left = recur(root.left, curSum);
        int right = recur(root.right, curSum);

        //计算所有结果
        res = res + left + right;

        //本层路径状态还原，放置左右子树值相同导致结果错误
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) - 1);
        return res;
    }
}
