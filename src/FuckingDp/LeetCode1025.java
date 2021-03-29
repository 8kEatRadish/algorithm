package FuckingDp;

/**
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * <p>
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 * <p>
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * <p>
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 False。假设两个玩家都以最佳状态参与游戏。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divisor-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode1025 {

    //一次写通过且一脸懵逼
//    public boolean divisorGame(int n) {
//        return (n & 1) != 1;
//    }

    public boolean divisorGame(int n) {
        boolean[] dpTable = new boolean[n + 2];

        dpTable[1] = false;
        dpTable[2] = true;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !dpTable[i - j]) {
                    dpTable[i] = true;
                }
            }
        }

        return dpTable[n];
    }
}
