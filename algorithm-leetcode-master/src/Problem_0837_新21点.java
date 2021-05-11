
import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/5/9 10:50
 */
public class Problem_0837_新21点 {
    public static void main(String[] args) {
        System.out.println(new Problem_0837_新21点().new21Game(5710, 5070, 8516));
    }

    //根据暴力递归来来的
    public double new21Game(int N, int K, int W) {
        double xi = 1.0 / W;

        double[] dp = new double[K + W + 1];
        for (int i = K; i <= K + W; i++) {
            dp[i] = (i <= N ? 1 : 0);
        }

        double sum = 0;
        for (int j = 1; j <= W; j++) {
            sum += dp[K - 1 + j];
        }

        for (int i = K - 1; i >= 0; i--) {
            dp[i] = sum * xi;
            sum = dp[i] + sum  - dp[i + W];
        }
        return dp[0];
    }

    //看别人的解法 可以对相同的进行合并
    public double new21Game3(int N, int K, int W) {
        double[] dp = new double[K + W];
        double sum = 0.0;
        for (int i = K; i < K + W; i++) {
            dp[i] = (i <= N ? 1.0 : 0.0);
            sum += dp[i];
        }
        for (int i = K - 1; i > -1; i--) {
            dp[i] = sum / W;
            sum = sum - dp[i + W] + dp[i];
        }
        return dp[0];

    }

    // 由数学公式推导出来的 这个看官网 难！
    public double new21Game2(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        double[] dp = new double[K + W];
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
        dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
        for (int i = K - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        }
        return dp[0];
    }


    public double new21Game1(int N, int K, int W) { //1-W
        double xi = 1.0 / W;
        Map<Integer, Double> map = new HashMap<>();
        return process(N, K, W, xi, 0, map);
    }

    private double process(int N, int K, int W, double xi, int curScore, Map<Integer, Double> map) {
        if (map.containsKey(curScore))
            return map.get(curScore);
        if (curScore >= K)
            return curScore <= N ? 1 : 0;

        double sum = 0;
        for (int i = 1; i <= W; i++) {
            sum += process(N, K, W, xi, curScore + i, map);
        }
        sum = sum * xi;
        map.put(curScore, sum);
        return sum;
    }
}
