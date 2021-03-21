package FuckingBinaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class LeetCode96 {

    //题目要求是计算不同二叉搜索树的个数。为此，我们可以定义两个函数：
    //
    //G(n)G(n): 长度为 nn 的序列能构成的不同二叉搜索树的个数。
    //
    //F(i, n)F(i,n): 以 ii 为根、序列长度为 nn 的不同二叉搜索树个数 (1 \leq i \leq n)(1≤i≤n)。

    //F(i,n)=G(i−1)⋅G(n−i)

    //G(n)=
    //i=1
    //∑
    //n
    //​
    // G(i−1)⋅G(n−i)(3)
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[i - j] * G[j - 1];
            }
        }

        return G[n];
    }
}
