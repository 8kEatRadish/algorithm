package FuckingHot;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *  
 *
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode415 {
    public String addStrings(String num1, String num2) {
        int num1Len = num1.length() - 1;
        int num2Len = num2.length() - 1;
        int add = 0;

        StringBuilder ans = new StringBuilder();

        while(num1Len >= 0 || num2Len >= 0 || add != 0){
            int x = num1Len >= 0 ? num1.charAt(num1Len) - '0' : 0;
            int y = num2Len >= 0 ? num2.charAt(num2Len) - '0' : 0;
            int n = x + y + add;

            ans.append(n % 10);
            add = n/10;
            num2Len--;
            num1Len--;
        }

        return ans.reverse().toString();
    }
}
