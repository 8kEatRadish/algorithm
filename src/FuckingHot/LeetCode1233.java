package FuckingHot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
 *
 * 我们这样定义「子文件夹」：
 *
 * 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的子文件夹。
 * 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：
 *
 * / 后跟一个或者多个小写英文字母。
 * 例如，/leetcode 和 /leetcode/problems 都是有效的路径，而空字符串和 / 不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-sub-folders-from-the-filesystem
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode1233 {
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList();
        Set<String> set = new HashSet();

        for(String s : folder){
            set.add(s);
        }

        for(String s : folder){
            int i = s.length() - 1;
            boolean flag = true;
            for(; i>1;i--){
                if(s.charAt(i) == '/'&& set.contains(s.substring(0,i))){
                    flag = false;
                    break;
                }
            }
            if(flag){
                res.add(s);
            }
        }
        return res;

    }
}
