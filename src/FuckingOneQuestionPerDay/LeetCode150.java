package FuckingOneQuestionPerDay;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 * <p>
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode150 {
    public static void main(String[] args) {
        String[] tokens = new String[]{"4", "13", "5", "/", "+"};
        new LeetCode150().evalRPN(tokens);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.add(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.add(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.add(stack.pop() * stack.pop());
                    break;
                case "/":
                    int temp = stack.pop();
                    stack.add(stack.pop() / temp);
                    break;
                default:
                    stack.add(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
