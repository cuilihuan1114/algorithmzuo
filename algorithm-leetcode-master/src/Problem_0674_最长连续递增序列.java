
/**
 * @author cuilihuan
 * @data 2021/3/26 14:25
 */
public class Problem_0674_最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = 1;
        int pre = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                pre = pre + 1;
            else
                pre = 1;
            max = Math.max(max, pre);
        }
        return max;
    }
}