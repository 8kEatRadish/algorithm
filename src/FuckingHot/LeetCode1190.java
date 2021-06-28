package FuckingHot;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中 不应 包含任何括号。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode1190 {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> temp = new LinkedList();

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                temp.push(i);
            }else if(s.charAt(i) == ')'){
                int j = temp.poll();
                pair[j] = i;
                pair[i] = j;
            }
        }

        int index = 0, step = 1;
        StringBuffer sb = new StringBuffer();
        while(index < n){
            if(s.charAt(index) == '(' || s.charAt(index) == ')'){
                index = pair[index];
                step = -step;
            }else{
                sb.append(s.charAt(index));
            }
            index += step;
        }
        return sb.toString();
    }
}
