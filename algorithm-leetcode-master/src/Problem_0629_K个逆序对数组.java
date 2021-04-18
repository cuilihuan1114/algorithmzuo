/**
 * @author cuilihuan
 * @data 2021/3/23 14:11
 */
public class Problem_0629_K个逆序对数组 {

    public static void main(String[] args) {
        System.out.println(new Problem_0629_K个逆序对数组().kInversePairs(1, 1));
    }

    public int kInversePairs(int n, int k) {
        if (k == 0) return 1;
        int pre = n;
        n = Math.max(n, k);

        long[][] dp = new long[n + 1][n + 1];

        dp[0][0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        dp[1][1] = 0;

        for (int i = 2; i <= pre; i++) {
            for (int j = 1; j <= k; j++) {
                // 在减的时候 一开始没有加后面的pow这个值 这样会出错 因为前面这两个值可能是刚刚求完的 后面是没有求的 小的减大的 自然为负数 所以在这里需要加一个值
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - (j - i >= 0 ? dp[i - 1][j - i] : 0) + (long) Math.pow(10, 9) + 7;
//                for (int l = j; l >= Math.max(j - i + 1, 0); l--) {
//                    dp[i][j] += dp[i - 1][l];
//                }
                dp[i][j] = dp[i][j] % ((long) Math.pow(10, 9) + 7);
            }
        }
        return (int) dp[pre][k];
    }
}
