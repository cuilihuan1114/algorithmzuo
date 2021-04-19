package D0414;

import java.util.*;

/**
 * @author cuilihuan
 * @data 2021/4/8 21:18
 */
public class Problem_0740_删除与获得点数 {


    public static void main(String[] args) {
        System.out.println(new Problem_0740_删除与获得点数().deleteAndEarn(new int[]{3, 4, 2}));
    }

    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] all = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            all[nums[i]] += nums[i];
        }


        int[] dp = new int[all.length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return process(all, 0, dp);
    }

    public int process(int[] nums, int index, int[] dp) {

        if (nums.length <= index)
            return 0;

        if (dp[index] > -1)
            return dp[index];

        int p1 = 0;
        int p2 = 0;

        int sum = 0;
        if (index + 1 < nums.length) {
            int next = nums[index + 1];
            if (next == 0)
                sum = nums[index] + process(nums, index + 2, dp);
            else {
                p1 = nums[index] + process(nums, index + 2, dp);
                p2 = nums[index + 1] + process(nums, index + 3, dp);
                sum = Math.max(p1, p2);
            }
        } else {
            sum = nums[index];
        }


        dp[index] = sum;
        return sum;
    }

    // 普通方法 超时
    public int deleteAndEarn1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;


        boolean[] flag = new boolean[nums.length];
        return process1(nums, flag);
    }

    private int process1(int[] nums, boolean[] flag) {
        int max = 0;
        for (int i = 0; i < flag.length; i++) {
            if (!flag[i]) {
                int cur = nums[i];
                flag[i] = true;
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < nums.length; j++) {
                    if ((nums[j] == cur - 1 || nums[j] == cur + 1) && !flag[j]) {
                        flag[j] = true;
                        list.add(j);
                    }
                }

                max = Math.max(max, nums[i] + process1(nums, flag));
                flag[i] = false;
                for (int j = 0; j < list.size(); j++) {
                    flag[list.get(j)] = false;
                }
            }
        }

        return max;
    }

































}
