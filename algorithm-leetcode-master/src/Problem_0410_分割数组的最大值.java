
/**
 * @author cuilihuan
 * @data 2021/3/8 18:02
 */
public class Problem_0410_分割数组的最大值 {

    public static void main(String[] args) {
        System.out.println(new Problem_0410_分割数组的最大值().splitArray(new int[]{10,5,13,4,8,4,5,11,14,9,16,10,20,8
        }, 8));
    }

    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum[i] = (i == 0 ? nums[i] : nums[i] + sum[i - 1]);
        }

        if(m == 1)
            return sum[nums.length - 1];

        int[][] cache = new int[nums.length + 1][m + 1];
        for (int i = 0; i < cache.length; i++) {
            for (int j =   0; j < cache[0].length; j++) {
                cache[i][j] = -1;
            }

        }
        return process(nums, sum, 0, m, cache);


    }

    private int process(int[] nums, int[] sum, int index, int remain, int[][] cache) {
        if (remain == 0)
            return 0;

        if (remain == 1) {
            return sum[nums.length - 1] - (index > 0 ? sum[index - 1] : 0);
        }

        if(cache[index][remain] != -1)
            return cache[index][remain];

        int cur = 0;
        int pre = Integer.MAX_VALUE;
        for (int i = index; i < nums.length && i + remain <= nums.length; i++) {
            cur = sum[i] - (index > 0 ? sum[index - 1] : 0);
            cur = Math.max(cur, process(nums, sum, i + 1, remain - 1, cache));
            pre = Math.min(pre, cur);
        }

        cache[index][remain] = pre;
        return pre;

    }
}
