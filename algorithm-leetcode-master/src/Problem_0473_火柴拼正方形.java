/**
 * @author cuilihuan
 * @data 2021/3/13 16:31
 */
public class Problem_0473_火柴拼正方形 {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4)
            return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 4 != 0)
            return false;
        int target = sum / 4;
        boolean[] flag = new boolean[nums.length];
        return process(nums, 0, flag, target, 0, 1);
    }

    private boolean process(int[] nums, int index, boolean[] flag, int target, int cur, int count) {
        if (index == nums.length)
            return false;
        boolean f = false;
        if (count < 3) {
            if (process(nums, index + 1, flag, target, cur, count) && process(nums, 0, flag, target, 0, count + 1)) {
                return true;
            }

            if (!flag[index]) {
                flag[index] = true;
                if (nums[index] + cur > target)
                    f = false;
                else if (nums[index] + cur == target && process(nums, 0, flag, target, 0, count + 1))
                    f = true;
                else if (process(nums, index + 1, flag, target, nums[index] + cur, count) && process(nums, 0, flag, target, 0, count + 1))
                    f = true;
                flag[index] = false;
            }

        } else {
            if (process(nums, index + 1, flag, target, cur, count)) {
                return true;
            }
            if (!flag[index]) {
                flag[index] = true;
                if (nums[index] + cur > target)
                    f = false;
                else if (nums[index] + cur == target)
                    f = true;
                else if (process(nums, index + 1, flag, target, nums[index] + cur, count))
                    f = true;
                flag[index] = false;
            }
        }

        return f;
    }
}
