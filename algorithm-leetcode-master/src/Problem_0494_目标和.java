import java.lang.annotation.Target;

/**
 * Created by CUI on 2021/2/24
 */
public class Problem_0494_目标和 {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0)
            return 0;
        return process(nums, 0, S);
    }

    public int process(int[] nums, int index, int target) {
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }
        int p1 = process(nums, index + 1, target - nums[index]);
        int p2 = process(nums, index + 1, target + nums[index]);
        return p1 + p2;
    }

    public int findTargetSumWays1(int[] nums, int S) {
        if (nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if(sum < S)
            return 0;

        int[][] dp = new int[nums.length + 1][2 * sum + 1];
        dp[nums.length][sum] = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = -sum; j <= sum; j++) {
                if (j - nums[i] + sum >= 0)
                    dp[i][j+sum] += dp[i + 1][j - nums[i] + sum];
                if (j + nums[i] + sum <= 2 * sum)
                    dp[i][j+sum] += dp[i + 1][j + nums[i] + sum];
            }
        }
        return dp[0][S + sum];
    }
}
