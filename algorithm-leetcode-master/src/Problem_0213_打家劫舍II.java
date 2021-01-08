/**
 * Created by CUI on 2021/1/7
 */
public class Problem_0213_打家劫舍II {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int max = Integer.MIN_VALUE;
        int pre = nums[0];
        int cur = Math.max(pre,nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            int temp = cur;
            cur = Math.max(cur, pre + nums[i]);
            pre = temp;
        }
        max = Math.max(max, cur);

        pre = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (i == 2) {
                cur = Math.max(pre, nums[i]);
            }else{
                int temp = cur;
                cur = Math.max(cur, pre + nums[i]);
                pre = temp;
            }
        }
        max = Math.max(max, cur);
        return max;
    }
}
