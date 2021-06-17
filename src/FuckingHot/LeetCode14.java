package FuckingHot;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        int len = Integer.MAX_VALUE;
        for(int i = 0; i< strs.length; i++){
            len = Math.min(len, strs[i].length());
        }
        if(len == 0) return "";

        out:for(int i = len; i > 0; i--){
            String s = strs[0].substring(0,i);
            for(int j = 0; j < strs.length; j ++){
                if(!s.equals(strs[j].substring(0,i))){
                    continue out;
                }
            }
            return s;
        }

        return "";
    }
}
