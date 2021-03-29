package FuckingDp;

/**
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 */
public class LeetCode1617 {
    public int maxSubArray(int[] nums) {
        int[] dpTable = new int[nums.length + 1];
        dpTable[0] = nums[0];
        int ans = dpTable[0];
        for (int i = 1; i < nums.length; i++){
            if (dpTable[i - 1] > 0){
                dpTable[i] = dpTable[i - 1] + nums[i];
            }else {
                dpTable[i] = nums[i];
            }
            ans = Math.max(ans,dpTable[i]);
        }
        return ans;
    }
}
