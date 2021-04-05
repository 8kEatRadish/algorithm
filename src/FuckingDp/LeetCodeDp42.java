package FuckingDp;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class LeetCodeDp42 {
    //dp方法
//    public int trap(int[] height) {
//        int len = height.length;
//
//        if (len == 0) {
//            return 0;
//        }
//
//
//        //统计第i个高度左侧最高点
//        int[] leftMax = new int[len];
//        leftMax[0] = height[0];
//
//        for (int i = 1; i < len; i++) {
//            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
//        }
//
//        //统计第i个高度右侧最高点
//        int[] rightMax = new int[len];
//        rightMax[len - 1] = height[len - 1];
//
//        for (int i = len - 2; i >= 0; i--) {
//            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
//        }
//
//        //算出答案，左右高度小的那个减去本身，表示该点存水多少
//        int ans = 0;
//        for (int i = 0; i < len; i++) {
//            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
//        }
//
//        return ans;
//    }

    //双指针
    public int trap(int[] height) {
        int len = height.length;
        if (len == 0) {
            return 0;
        }

        int left = 0;
        int right = len - 1;

        int leftMax = 0, rightMax = 0;
        int ans = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
