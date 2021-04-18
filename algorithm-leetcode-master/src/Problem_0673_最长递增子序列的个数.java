import java.util.HashMap;
import java.util.Stack;

/**
 * @author cuilihuan
 * @data 2021/3/26 10:35
 */
public class Problem_0673_最长递增子序列的个数 {

    public static void main(String[] args) {
                System.out.println(new Problem_0673_最长递增子序列的个数().findNumberOfLIS(new int[]{2,2,2}));
    }


    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        HashMap<Integer, Integer> pos = new HashMap<>();
        int max = 1;
        dp[0] = 1;
        pos.put(0, 1);
        for (int i = 1; i < nums.length; i++) {
            pos.put(i, 1);
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        pos.put(i, pos.get(j));
                        dp[i] = dp[j] + 1;
                    } else if (dp[j] + 1 == dp[i])
                        pos.put(i, pos.get(i) + pos.get(j));
                }
            }
            max = Math.max(dp[i], max);
        }

        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            if(max == dp[i]){
                count += pos.get(i);
            }
        }
        return count;
    }
}
