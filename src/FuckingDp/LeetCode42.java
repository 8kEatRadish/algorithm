package FuckingDp;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 */
public class LeetCode42 {
    public int maxSubArray(int[] nums) {

        int[] dpTable = new int[nums.length + 1];
        dpTable[0] = nums[0];
        int ans = dpTable[0];
        for (int i = 1; i < nums.length; i++) {
            if (dpTable[i - 1] <= 0) {
                dpTable[i] = nums[i];
            } else if (dpTable[i - 1] > 0) {
                dpTable[i] = dpTable[i - 1] + nums[i];
            }
            ans = Math.max(ans, dpTable[i]);
        }

        return ans;
    }
}
