
/**
 * @author cuilihuan
 * @data 2021/5/27 10:03
 */
public class Problem_0896_单调数列 {
    public boolean isMonotonic(int[] nums) {
        if(nums == null || nums.length == 0)
            return true;

        boolean flag = true;
        for (int i = 1 ; i < nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                flag = false;
                break;
            }
        }

        if(flag)
            return true;

        flag = true;
        for (int i = 1 ; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
