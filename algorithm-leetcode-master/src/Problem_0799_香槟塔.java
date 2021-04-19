package D0501;

/**
 * @author cuilihuan
 * @data 2021/4/17 19:02
 */
public class Problem_0799_香槟塔 {

    public static void main(String[] args) {
        System.out.println(new Problem_0799_香槟塔().champagneTower(1, 1, 1));
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 1][query_glass+1];
        dp[0][0] = poured;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = (j > 0 ? Math.max(0, (dp[i - 1][j - 1] - 1) / 2) : 0) + Math.max(0, (dp[i - 1][j] - 1) / 2);
            }
        }

        return dp[query_row][query_glass] > 1 ? 1 : dp[query_row ][query_glass];
    }


}
