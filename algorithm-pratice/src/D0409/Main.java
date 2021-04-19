package D0409;

import java.util.Scanner;

/**
 * @author cuilihuan
 * @data 2021/4/11 10:54
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] nums = new int[N];
        String s = input.next();
        for (int i = 0; i < s.length(); i++) {
            nums[i] = s.charAt(i) - '0';
        }

        int[] dp = new int[nums.length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        int p1 = processOne(nums, 0, dp);

        dp = new int[nums.length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        int p2 = processZero(nums, 0, dp);
        System.out.println(Math.max(p1, p2));

    }

    private static int processOne(int[] nums, int index, int[] dp) {
        if (dp[index] > -1)
            return dp[index];
        if (index == nums.length)
            return 0;
        int cur = nums[index];

        int ans = 0;
        // 当前不消除
        int zero = (cur == 0 ? 1 : 0);
        int one = (cur == 1 ? 1 : 0);
        ans = one - zero + processOne(nums, index + 1, dp);

        if (index + 2 < nums.length) {
            int p1 = processOne(nums, index + 3, dp);
            ans = Math.max(ans, p1);
        }
        dp[index] = ans;
        return ans;
    }

    private static int processZero(int[] nums, int index, int[] dp) {
        if (dp[index] > -1)
            return dp[index];
        if (index == nums.length)
            return 0;
        int cur = nums[index];
        int ans = 0;
        // 当前不消除
        int zero = (cur == 0 ? 1 : 0);
        int one = (cur == 1 ? 1 : 0);
        ans = zero - one + processZero(nums, index + 1, dp);

        if (index + 2 < nums.length) {
            int p1 = processZero(nums, index + 3, dp);
            ans = Math.max(ans, p1);
        }
        dp[index] = ans;
        return ans;
    }
}
