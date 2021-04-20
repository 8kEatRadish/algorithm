package FuckingDp;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode300 {
    public static void main(String[] args) {

    }
    // public int lengthOfLIS(int[] nums) {
    //     if(nums.length == 0){
    //         return 0;
    //     }
    //     int[] dpTable = new int[nums.length];
    //     dpTable[0] = 1;
    //     int ans = 1;
    //     for(int i = 1; i< nums.length; i++){
    //         dpTable[i] = 1;
    //         for(int j = 0; j < i; j++){
    //             if(nums[j] < nums[i]){
    //                 dpTable[i] = Math.max(dpTable[i], dpTable[j] + 1);
    //             }
    //         }
    //         ans = Math.max(dpTable[i], ans);
    //     }
    //     return ans;
    // }

    public int lengthOfLIS(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int[] dpTable = new int[nums.length + 1];
        int len = 1;
        dpTable[len] = nums[0];

        for(int i = 1;i < nums.length; i++){
            if(dpTable[len] < nums[i]){
                dpTable[++len] = nums[i];
            }else{
                int l = 1,r = len,pos = 0;
                while(l <= r){
                    int mid = l + ((r - l) >> 1);
                    if(dpTable[mid] < nums[i]){
                        pos = mid;
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                }
                dpTable[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
