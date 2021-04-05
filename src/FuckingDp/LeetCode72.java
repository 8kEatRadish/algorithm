package FuckingDp;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode72 {
    public int minDistance(String word1, String word2) {
        int word1Len = word1.length();
        int word2Len = word2.length();

        int[][] dpTable = new int[word1Len + 1][word2Len + 1];

        for (int i = 0; i <= word1Len; i++) {
            dpTable[i][0] = i;
        }

        for (int i = 0; i <= word2Len; i++) {
            dpTable[0][i] = i;
        }

        for (int i = 1; i <= word1Len; i++) {
            for (int j = 1; j <= word2Len; j++) {
                int temp = Math.min(dpTable[i - 1][j] + 1, dpTable[i][j - 1] + 1);
                dpTable[i][j] = Math.min(temp, dpTable[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1));
            }
        }

        return dpTable[word1Len][word2Len];
    }
}
