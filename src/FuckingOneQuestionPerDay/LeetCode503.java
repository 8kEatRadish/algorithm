package FuckingOneQuestionPerDay;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode503 {

    public static void main(String[] args) {
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 1;

        System.out.println(Arrays.toString(new LeetCode503().nextGreaterElements(arr)));
    }

    /**
     * 使用单调栈，在栈里维护一个从大到小的顺序，如果有破坏顺序的数据要进入栈的时候，pop比他小的数据，弹出的数据下一个更大的元素就是
     * 这个数据。
     */
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n - 1; i++) {
            while (!stack.empty() && nums[stack.peek()] < nums[i % n]) {
                ans[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }

        return ans;
    }
}
