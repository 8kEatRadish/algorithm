package FuckingDp;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode10 {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dpTable = new boolean[m + 1][n + 1];

        dpTable[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (p.charAt(j - 1) != '*') {
                    if (matcher(s, p, i, j)) {
                        dpTable[i][j] = dpTable[i - 1][j - 1];
                    }
                } else {
                    dpTable[i][j] = dpTable[i][j - 2];
                    if (matcher(s, p, i, j - 1)) {
                        dpTable[i][j] = dpTable[i][j] || dpTable[i - 1][j];
                    }
                }

            }
        }

        return dpTable[m][n];
    }

    private boolean matcher(String s, String p, int i, int j) {

        if (i == 0) {
            return false;
        }

        if (p.charAt(j - 1) == '.') {
            return true;
        }

        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
