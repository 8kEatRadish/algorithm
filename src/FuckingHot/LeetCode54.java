package FuckingHot;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> ans = new LinkedList();
        if(matrix == null || matrix.length == 0) return ans;

        int top = 0,right = matrix[0].length - 1, left = 0, bottom = matrix.length - 1;
        int num = matrix.length * matrix[0].length;

        while(num > 0){
            for(int i = left; i <= right && num > 0; i++){
                ans.add(matrix[top][i]);
                num--;
            }
            top++;
            for(int i = top; i <= bottom && num > 0; i ++){
                ans.add(matrix[i][right]);
                num--;
            }
            right--;
            for(int i = right; i >= left && num > 0; i--){
                ans.add(matrix[bottom][i]);
                num--;
            }
            bottom--;
            for(int i = bottom; i >= top && num > 0; i--){
                ans.add(matrix[i][left]);
                num--;
            }
            left++;
        }

        return ans;
    }
}
