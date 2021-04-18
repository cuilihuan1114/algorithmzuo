import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/4/7 15:56
 */
public class Problem_0689_三个无重叠子数组的最大和 {


    public static void main(String[] args) {
        int[] res = new Problem_0689_三个无重叠子数组的最大和().maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }

    // 此题有一个很重要的信息就是中间的那一段的长度是固定的 因此可以根据固定的这一段进行滑动 左右两边的便也可以方便的利用动态规划求解
    // left[i] 表示到0-i位的长度为k的和最大值的位置
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1, -1};


        int[] dp = new int[nums.length];
        for (int i = 0; i < k; i++) {
            dp[0] += nums[i];
        }
        for (int i = 1; i < nums.length - k + 1; i++) {
            dp[i] = dp[i - 1] - nums[i - 1] + nums[i + k - 1];
        }

        int[] left = new int[nums.length - k + 1];
        left[0] = 0;

        int[] right = new int[nums.length - k + 1];
        right[right.length - 1] = nums.length - k;

        // 注意如果相同的是返回最左边的 所以这里是i > i - 1
        for (int i = 1; i < left.length; i++) {
            left[i] = (dp[i] > dp[left[i - 1]]) ? i : left[i - 1];
        }


        // 这里是 i + 1 > i
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = (dp[right[i + 1]] > dp[i] ? right[i + 1] : i);
        }

        int[] res = new int[3];
        int max = 0;
        for (int i = k; i < nums.length - k * 2 + 1; i++) {
            int p = dp[left[i - k]] + dp[i] + dp[right[i + k]];
            if (p > max) {
                max = p;
                res[0] = left[i - k];
                res[1] = i;
                res[2] = right[i + k];
            }
        }

        return res;
    }


    // 从左到右一个个找 时间复杂度为o(n2) 但是会超时 即使使用暴力搜索加记忆化
    public int[] maxSumOfThreeSubarrays1(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1, -1};

        int[] res = new int[3];

        int[] dp = new int[nums.length];
        for (int i = 0; i < k; i++) {
            dp[0] += nums[i];
        }
        for (int i = 1; i < nums.length - k + 1; i++) {
            dp[i] = dp[i - 1] - nums[i - 1] + nums[i + k - 1];
        }

        Map<String, Integer> map = new HashMap<>();
        Map<String, int[]> map1 = new HashMap<>();
        process(nums, k, dp, 0, 0, res, map, map1);

        return res;
    }

    private int process(int[] nums, int length, int[] dp, int index, int remain, int[] res, Map<String, Integer> map, Map<String, int[]> map1) {
        if (remain == 3)
            return 0;

        String code = getCode(index, remain);
        if (map.containsKey(code)) {
            int[] maxCur = map1.get(code);
            for (int i = 0; i < maxCur.length; i++) {
                res[i + remain] = maxCur[i];
            }
            return map.get(code);
        }

        if (index == nums.length)
            return -1;

        if (nums.length - index < length)
            return -1;

        int max = Integer.MIN_VALUE;
        int[] maxCur = new int[3 - remain];
        for (int i = index; i < nums.length - ((3 - remain) * length) + 1; i++) {
            int cur = dp[i];
            int p1 = process(nums, length, dp, i + length, remain + 1, res, map, map1);
            if (p1 != -1) {
                if (p1 + cur > max) {
                    max = p1 + cur;
                    res[remain] = i;
                    for (int j = 0; j < maxCur.length; j++) {
                        maxCur[j] = res[remain + j];
                    }
                }
            }
        }

        for (int i = 0; i < maxCur.length; i++) {
            res[i + remain] = maxCur[i];
        }

        map.put(code, max);
        map1.put(code, maxCur);

        return max == Integer.MIN_VALUE ? -1 : max;
    }

    private String getCode(int index, int remain) {
        return index + "_" + remain;
    }
}