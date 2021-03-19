package FuckingBinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-frequent-subtree-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode508 {

    //保存路径和出现次数
    Map<Integer,Integer> sumMap = new HashMap<>();
    //出现最大次数
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        helper(root);

        ArrayList<Integer> temp = new ArrayList<>();
        for (int key : sumMap.keySet()){
            if (sumMap.get(key) == max){
                temp.add(key);
            }
        }

        int[] ans = new int[temp.size()];

        for (int i = 0; i < temp.size(); i++){
            ans[i] = temp.get(i);
        }

        return ans;

    }
    private int helper(TreeNode root) {
        //递归边界
        if (root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);

        int res = root.val + left + right;

        sumMap.put(res,sumMap.getOrDefault(res,0) + 1);
        max = Math.max(max,sumMap.get(res));
        return res;
    }
}
