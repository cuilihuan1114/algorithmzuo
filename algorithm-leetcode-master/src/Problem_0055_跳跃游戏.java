/**
 * @author cuilihuan
 * @data 2020/12/2 20:47
 */
public class Problem_0055_跳跃游戏 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i <= max)
                max = Math.max(max, nums[i] + i);
        }
        return max >= nums.length - 1;
    }

}
