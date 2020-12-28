/**
 * @author cuilihuan
 * @data 2020/11/29 21:46
 */
public class Problem_0070_爬楼梯 {
    public static void main(String[] args) {
        System.out.println(new Problem_0070_爬楼梯().climbStairs(2));
    }

    //真正的动态规划
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //暴力递归+缓存 = 动态规划
    public int climbStairs2(int n) {
        int[] cache = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            cache[i] = -1;
        }
        return process(n, cache);
    }

    private int process(int n, int[] cache) {
        if (n == 0)
            return 1;
        if (n < 0)
            return -1;
        if (cache[n] >= 0)
            return cache[n];

        int p1 = process(n - 1, cache);
        int p2 = process(n - 2, cache);
        int sum = 0;
        if (p1 > 0)
            sum += p1;
        if (p2 > 0)
            sum += p2;
        cache[n] = sum;
        return sum;

    }

    //暴力递归法 时间会超出限制
    public int climbStairs1(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return -1;
        int p1 = climbStairs1(n - 1);
        int p2 = climbStairs1(n - 2);
        int sum = 0;
        if (p1 > 0)
            sum += p1;
        if (p2 > 0)
            sum += p2;
        return sum;
    }

}
