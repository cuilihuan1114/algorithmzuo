
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author cuilihuan
 * @data 2021/5/29 9:45
 */
public class Problem_0945_使数组唯一的最小增量 {

    public static void main(String[] args) {
        System.out.println(new Problem_0945_使数组唯一的最小增量().minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }

    public int minIncrementForUnique(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        Arrays.sort(nums);
        int ans = 0;
        for (int i = 1 ; i < nums.length; i++) {
            if(nums[i] <= nums[i-1]){
                int tmp = nums[i];
                nums[i] = nums[i - 1] + 1;
                ans = ans+ nums[i] - tmp;
            }
        }

        return ans;
    }
}
