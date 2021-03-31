package FuckingDp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 致谢：
 * <p>
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode392 {
    //第一次写
//    public boolean isSubsequence(String s, String t) {
//        int[] ans = new int[s.length()];
//        Arrays.fill(ans, 1);
//
//        for (int i = 0, j = 0; i < t.length() && j < s.length(); i++) {
//            if (t.charAt(i) == s.charAt(j)){
//                ans[j] = 0;
//                j++;
//            }
//        }
//
//        int res = 0;
//        for (int i = 0; i < ans.length; i++) {
//            res += ans[i];
//        }
//
//        return res == 0;
//    }
    //优化1 空间复杂度为1 用双指针
    public boolean isSubsequence(String s, String t) {
        int sP = 0, tP = 0;
        while (sP < s.length() && tP < t.length()) {
            if (s.charAt(sP) == t.charAt(tP)) {
                sP++;
            }
            tP++;
        }

        return sP == s.length();
    }
}
