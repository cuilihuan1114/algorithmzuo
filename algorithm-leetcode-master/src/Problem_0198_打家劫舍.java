/**
 * Created by CUI on 2021/1/1
 */
public class Problem_0198_打家劫舍 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int prepre = nums[0];
        int pre = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int cur = Math.max(pre, prepre + nums[i]);
            prepre = pre;
            pre = cur;
        }
        return pre;
    }
}
