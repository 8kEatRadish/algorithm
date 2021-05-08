package FuckingHot;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode03 {

//    public int findRepeatNumber(int[] nums) {
//        int ans = 0;
//        Map<Integer,Integer> map = new HashMap();
//
//        for(int i = 0; i < nums.length; i++){
//            if(map.containsKey(nums[i])){
//                ans = nums[i];
//                break;
//            }else{
//                map.put(nums[i], 1);
//            }
//        }
//
//        return ans;
//    }


    //因为在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内；所以nums[k]不会越界，如果有重复的数字，那么nums[k]会小于0
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i ++){
            int k = nums[i];
            if(k < 0){
                k += n;
            }
            if(nums[k] < 0) return k;
            nums[k] -= n;
        }

        return -1;
    }
}
