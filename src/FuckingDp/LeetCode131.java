package FuckingDp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class LeetCode131 {
    boolean[][] dpTable;
    List<List<String>> res = new ArrayList();
    List<String> ans = new ArrayList();
    int len;
    public List<List<String>> partition(String s) {
        len = s.length();
        dpTable = new boolean[s.length() + 1][s.length() + 1];
        for(int i = 0; i < s.length(); i++){
            Arrays.fill(dpTable[i], true);
        }

        for(int i = len - 1; i >= 0; i--){
            for(int j = i + 1; j < len; j++){
                dpTable[i][j] = dpTable[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }

        dfs(s,0);

        return res;
    }


    public void dfs(String s,int n){
        if(n == len){
            res.add(new ArrayList<String>(ans));
            return;
        }

        for(int i = n; i < len;i ++){
            if(dpTable[n][i]){
                ans.add(s.substring(n,i + 1));
                dfs(s, i + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
