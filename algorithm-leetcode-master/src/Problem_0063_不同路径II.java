/**
 * @author cuilihuan
 * @data 2020/12/5 19:52
 */
public class Problem_0063_不同路径II {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
        int N = obstacleGrid.length - 1;
        int M = obstacleGrid[0].length - 1;
        int[][] dp = new int[N+1][M+1];
        dp[N][M] = obstacleGrid[N][M] == 1 ? 0 : 1;
        for (int i = M - 1; i >=0 ; i--) {
            dp[N][i] = obstacleGrid[N][i] == 1 ? 0 : dp[N][i + 1];
        }
        for (int i = N - 1; i >=0 ; i--) {
            dp[i][M] = obstacleGrid[i][M] == 1 ? 0 : dp[i+1][M];
        }
        for (int curX = N-1; curX >=0 ; curX--) {
            for (int curY = M-1; curY >=0 ; curY--) {
                int sum = 0;
                if(obstacleGrid[curX][curY] == 1)
                    dp[curX][curY] = 0;
                else{
                    sum += dp[curX][curY + 1];
                    sum += dp[curX + 1][curY];
                    dp[curX][curY] = sum;
                }
            }
        }
        return dp[0][0];
    }


    //暴力递归 会超时
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0)
            return 0;

        return process(obstacleGrid,0,0);
    }

    private int process(int[][] obstacleGrid, int curX, int curY) {
        if(obstacleGrid[curX][curY] == 1)
            return 0;

        if(curX == obstacleGrid.length - 1 && curY == obstacleGrid[0].length - 1)
            return 1;

        if(curX == obstacleGrid.length - 1)
            return process(obstacleGrid, curX, curY + 1);
        if(curY == obstacleGrid[0].length - 1)
            return process(obstacleGrid, curX + 1, curY);
        int sum = 0;
        sum += process(obstacleGrid, curX, curY + 1);
        sum += process(obstacleGrid, curX + 1, curY);
        return sum;
    }
}
