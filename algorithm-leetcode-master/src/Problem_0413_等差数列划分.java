/**
 * @author cuilihuan
 * @data 2021/3/12 19:54
 */
public class Problem_0413_等差数列划分 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length <= 2)
            return 0;
        // 当到某一个数的时候 有两种可能 一种是i-1前面是等差数列 判断自己能否加入进去
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = 0;

        int sum = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            sum += dp[i];
        }
        return sum;

    }
}
