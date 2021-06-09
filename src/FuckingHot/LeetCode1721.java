package FuckingHot;

/**
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 */
public class LeetCode1721 {
    public int trap(int[] height) {
        int sum  = 0;
        for(int i = 0; i < height.length; i++){
            sum += height[i];
        }

        if(height.length <= 1){
            return 0;
        }

        int v = 0;
        int left = 0;
        int right = height.length - 1;
        int h = 0;
        while(left < right){
            while(left < right && height[left] <= h) left++;
            while(left < right && height[right] <= h) right --;

            v += (right - left + 1) * (Math.min(height[left], height[right]) - h);
            h = Math.min(height[left], height[right]);
        }

        return v - sum;

    }
}
