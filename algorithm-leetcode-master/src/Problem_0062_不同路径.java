/**
 * @author cuilihuan
 * @data 2020/12/3 20:01
 */
public class Problem_0062_不同路径 {

    public static void main(String[] args) {
        System.out.println(new Problem_0062_不同路径().uniquePaths(3, 2));
    }

    //方法三 改写成动态规划
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n + 1];
        dp[m - 1][n - 1] = 1;
        for (int i = 0; i <= n; i++) {
            dp[m - 1][i] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }


    //方法二 加递归 动态
    public int uniquePaths2(int m, int n) {
        int[][] cache = new int[m + 1][n + 1];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {
                cache[i][j] = -1;
            }

        }
        return process(0, 0, m - 1, n - 1, cache);
    }

    private int process(int curX, int curY, int endX, int endY, int[][] cache) {
        if (cache[curX][curY] != -1)
            return cache[curX][curY];
        if (curX == endX && curY == endY)
            return 1;
        if (curX > endX || curY > endY)
            return 0;
        int sum = 0;
        sum += process(curX + 1, curY, endX, endY, cache);
        sum += process(curX, curY + 1, endX, endY, cache);
        cache[curX][curY] = sum;
        return sum;
    }

    //方法1 使用动态规划 但是超时了了了
    public int uniquePaths1(int m, int n) {
        return process1(0, 0, m - 1, n - 1);
    }

    private int process1(int curX, int curY, int endX, int endY) {
        if (curX == endX && curY == endY)
            return 1;
        if (curX > endX || curY > endY)
            return 0;
        int sum = 0;
        sum += process1(curX + 1, curY, endX, endY);
        sum += process1(curX, curY + 1, endX, endY);
        return sum;
    }
}
