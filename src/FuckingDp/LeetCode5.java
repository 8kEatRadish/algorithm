package FuckingDp;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LeetCode5 {

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int len = 0; len < n; len ++){
            for (int start = 0; start + len < n; start ++){
                int end = start + len;
                if (len == 0){
                    dp[start][end] = true;
                }else if (len == 1){
                    dp[start][end] = s.charAt(end) == s.charAt(start);
                }else {
                    dp[start][end] = dp[start + 1][end - 1] && s.charAt(start) == s.charAt(end);
                }

                if (dp[start][end] && len + 1> ans.length()){
                    ans = s.substring(start,end+1);
                }

            }
        }
        return ans;
    }
}
