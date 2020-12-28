/**
 * @author cuilihuan
 * @data 2020/12/2 22:08
 */
public class Problem_0053_最大子序和 {
    public static void main(String[] args) {
        System.out.println(new Problem_0053_最大子序和().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = pre < 0 ? nums[i] : pre + nums[i];
            max = Math.max(max, pre);
        }
        return max;
    }
}
