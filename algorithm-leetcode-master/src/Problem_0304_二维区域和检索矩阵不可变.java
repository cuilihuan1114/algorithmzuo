/**
 * Created by CUI on 2021/2/28
 */
public class Problem_0304_二维区域和检索矩阵不可变 {
    int[][] sum;


    public Problem_0304_二维区域和检索矩阵不可变(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            sum = new int[1][1];
            return;
        }
        sum = new int[matrix.length+1][matrix[0].length+1];
        int[] dp = new int[matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            int all = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                dp[j + 1] = dp[j + 1] + matrix[i][j];
                all += dp[j + 1];
                sum[i + 1][j + 1] = all;
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row1][col2+1] - sum[row2+1][col1] + sum[row1][col1];
    }
}
