
/**
 * @author cuilihuan
 * @data 2021/5/28 10:36
 */
public class Problem_0918_环形子数组的最大和 {
    public static void main(String[] args) {
        System.out.println(new Problem_0918_环形子数组的最大和().maxSubarraySumCircular(new int[]{-3,-2}));
    }
    public int maxSubarraySumCircular(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int maxRes = Integer.MIN_VALUE;
        int minRes = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int maxCur = Math.max(nums[i], i == 0 ? nums[i] : nums[i] + max);
            maxRes = Math.max(maxRes, maxCur);
            max = maxCur;

            int minCur = Math.min(nums[i], i == 0 ? nums[i] : nums[i] + min);
            minRes = Math.min(minRes, minCur);
            min = minCur;
        }

        if(maxRes < 0 )
            return maxRes;

        return Math.max(sum - minRes ,maxRes);
    }
}
