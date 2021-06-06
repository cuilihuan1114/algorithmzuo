

/**
 * @author cuilihuan
 * @data 2021/5/26 10:41
 */
public class Problem_0861_翻转矩阵后的得分 {

    public static void main(String[] args) {
        System.out.println(new Problem_0861_翻转矩阵后的得分().matrixScore(new int[][]{{0, 1, 0}, {0, 0, 1}}));
    }

    public int matrixScore(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;

        int[] dp = new int[col];
        dp[0] = row;
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(grid[i][0] == 0)
                    dp[j] = dp[j] + ((grid[i][j] == 0) ? 1 : 0);
                else
                    dp[j] = dp[j] + grid[i][j];
            }
        }

        int sum = 0;
        int multi = 1;
        for (int i = col - 1; i >= 0 ; i--) {
            sum = sum + multi * Math.max(dp[i], row - dp[i]);
            multi = multi * 2;
        }

        return sum;

    }
}
