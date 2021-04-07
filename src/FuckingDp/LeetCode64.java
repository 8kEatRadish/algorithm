package FuckingDp;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 */
public class LeetCode64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;

        int[][] dpTable = new int[row][column];
        dpTable[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dpTable[i][0] = dpTable[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < column; i++) {
            dpTable[0][i] = dpTable[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dpTable[i][j] = Math.min(dpTable[i - 1][j], dpTable[i][j - 1]) + grid[i][j];
            }
        }

        return dpTable[row - 1][column - 1];
    }
}
