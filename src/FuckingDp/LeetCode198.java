package FuckingDp;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode198 {
//    public int rob(int[] nums) {
//        int[] dpTable = new int[nums.length + 1];
//        dpTable[0] = 0;
//        dpTable[1] = nums[0];
//        for (int i = 2; i<= nums.length; i++){
//            dpTable[i] = Math.max(dpTable[i - 1],dpTable[i - 2] + nums[i - 1]);
//        }
//        return dpTable[nums.length];
//    }
    //优化
    public int rob(int[] nums) {
        int pre = 0;
        int cur = nums[0];
        int ans = 0;
        if (nums.length == 1){
            return nums[0];
        }
        for (int i = 2; i<= nums.length; i++){
            ans = Math.max(cur,pre + nums[i - 1]);
            pre = cur;
            cur = ans;
        }
        return ans;
    }
}
