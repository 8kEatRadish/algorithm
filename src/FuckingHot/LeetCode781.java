package FuckingHot;

import java.util.HashMap;
import java.util.Map;

/**
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
 *
 * 返回森林中兔子的最少数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rabbits-in-forest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode781 {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> temp = new HashMap();
        int ans = 0;

        for(int i = 0; i < answers.length; i ++){
            if(temp.getOrDefault(answers[i], 0) == 0){
                ans += answers[i] + 1;
                temp.put(answers[i], answers[i]);
            }else{
                temp.put(answers[i], temp.get(answers[i]) - 1);
            }
        }

        return ans;
    }
}
