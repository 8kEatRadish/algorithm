package FuckingOneQuestionPerDay;

import java.util.Arrays;

/**
 * @Author 隋宏伟
 * @Date 2021-03-03
 * @description 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 **/
public class LeetCode338 {
    public static void main(String[] args) {
        System.out.println("" + Arrays.toString(new LeetCode338().countBits(5)));
    }

    /**
     *
     * 对于一个奇数来说，二进制中1的数目为前一个偶数1的数目+1；
     * 对于一个偶数来说，二进制中1的数目和该数/2的1的数目相同
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 1) {
                ans[i] = ans[i - 1] + 1;
            } else {
                ans[i] = ans[i / 2];
            }
        }
        return ans;
    }
}
