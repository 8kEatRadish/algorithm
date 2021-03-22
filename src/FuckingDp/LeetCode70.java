package FuckingDp;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 */
public class LeetCode70 {

    public int climbStairs(int n) {
        int pre = 0,curr = 1,ans = 0;
        for (int i = 1; i <= n; i++){
            ans = pre + curr;
            pre = curr;
            curr = ans;
        }
        return ans;
    }
}
