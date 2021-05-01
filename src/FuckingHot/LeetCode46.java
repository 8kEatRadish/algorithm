package FuckingHot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class LeetCode46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();

        List<Integer> out = new ArrayList();

        for(int i = 0; i < nums.length; i++){
            out.add(nums[i]);
        }

        backtrack(nums.length, out, ans, 0);


        return ans;
    }

    public void backtrack(int n, List<Integer> out,List<List<Integer>> ans,int first){
        if(first == n){
            ans.add(new ArrayList<Integer>(out));
        }
        for(int i = first; i < n; i++){
            Collections.swap(out, first, i);
            backtrack(n, out, ans, first + 1);
            Collections.swap(out, first, i);
        }
    }
}
