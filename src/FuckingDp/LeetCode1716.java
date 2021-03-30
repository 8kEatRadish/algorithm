package FuckingDp;

/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode1716 {
    public int massage(int[] nums) {

        if (nums.length == 0){
            return  0;
        }

        int[] dpTable = new int[nums.length + 1];

        dpTable[0] = 0;
        dpTable[1] = nums[0];

        for (int i = 2; i <= nums.length; i++){
            dpTable[i] = Math.max(dpTable[i - 1],dpTable[i - 2] + nums[i - 1]);
        }

        return dpTable[nums.length];
    }
}
