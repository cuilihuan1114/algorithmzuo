/**
 * Created by CUI on 2021/1/6
 */
public class Problem_0152_乘积最大子数组 {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int preMax = nums[0];
        int preMin = nums[0];
        int curMax = preMax;
        int curMin = preMin;
        int max = curMax;
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], Math.max(nums[i] * preMax, nums[i] * preMin));
            curMin = Math.min(nums[i], Math.min(nums[i] * preMax, nums[i] * preMin));
            preMax = curMax;
            preMin = curMin;
            max = Math.max(max, curMax);
        }
        return max;
    }
}
