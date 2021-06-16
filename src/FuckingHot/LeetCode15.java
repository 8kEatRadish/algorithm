package FuckingHot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        if(nums.length < 2) return ans;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int targer = - nums[i];
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                if(nums[left] + nums[right] == targer){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    left ++; right --;
                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }

                    while(left < right && nums[right] == nums[right + 1]){
                        right --;
                    }

                }else{
                    if(nums[left] + nums[right] > targer){
                        right --;
                    }else{
                        left ++;
                    }
                }
            }
        }

        return ans;
    }
}
