
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/4/8 20:58
 */
public class Problem_0746_使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0)
            return 0;

        int[] dp = new int[cost.length+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return process(cost, 0,dp);
    }

    private int process(int[] cost, int index, int[] dp) {
        if(dp[index] > -1)
            return dp[index];

        if (index >= cost.length)
            return 0;
        int p1 = cost[index] + process(cost, index + 1, dp);
        int p2 = 0;
        if (index + 1 < cost.length)
            p2 = cost[index + 1] + process(cost, index + 2, dp);
        dp[index] = Math.min(p1, p2);
        return dp[index];
    }




}
