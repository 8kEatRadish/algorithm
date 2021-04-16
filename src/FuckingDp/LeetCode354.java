package FuckingDp;

import java.util.Arrays;

/**
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 *
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 注意：不允许旋转信封。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode354 {

    //用lis做

    int ans = 1;
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        int[] dpTable = new int[n + 1];

        Arrays.sort(envelopes,(e1, e2) -> {
            if(e1[0] == e2[0]){
                return e2[1] - e1[1];
            }
            return e1[0] - e2[0];
        });

        int ans = 0;
        for(int i = 0; i<n;i++){
            dpTable[i] = 1;
            for(int j = 0; j < i; j++){
                if(envelopes[i][1] > envelopes[j][1]){
                    dpTable[i] = Math.max(dpTable[i], dpTable[j] + 1);
                }
            }
            ans = Math.max(ans, dpTable[i]);
        }

        return ans;
    }

}
