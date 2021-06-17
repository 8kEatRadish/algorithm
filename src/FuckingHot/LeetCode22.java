package FuckingHot;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class LeetCode22 {
    List<String> ans = new ArrayList();

    public List<String> generateParenthesis(int n) {
        getParenthesis("", n, n);
        return ans;
    }

    public void getParenthesis(String str,int left,int right){
        if(left == 0 && right == 0){
            ans.add(str.toString());
            return;
        }

        if(left == right){
            getParenthesis( str + "(",left - 1, right);
        }else if(left < right){
            if(left > 0){
                getParenthesis( str + "(", left - 1, right);
            }
            getParenthesis( str + ")", left, right - 1);
        }
    }
}
