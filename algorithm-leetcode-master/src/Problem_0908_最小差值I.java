
/**
 * @author cuilihuan
 * @data 2021/5/27 10:40
 */
public class Problem_0908_最小差值I {
    public int smallestRangeI(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        min = min + k;
        max = max - k;
        return Math.max(max - min, 0);
    }
}
