package FuckingHot;

import java.util.HashSet;
import java.util.Set;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
public class LeetCode3 {
    //滑动窗口

    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        Set<Character> temp = new HashSet<Character>();
        int r = -1,ans = 0;
        for(int i = 0 ; i < s.length(); i++){
            if( i != 0){
                temp.remove(s.charAt(i - 1));
            }
            while(r + 1 < s.length() && !temp.contains(s.charAt(r + 1))){
                temp.add(s.charAt(r + 1));
                r++;
            }

            ans = Math.max(ans, r - i + 1);
        }
        return ans;
    }
}
