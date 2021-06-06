
import java.util.HashSet;

/**
 * @author cuilihuan
 * @data 2021/5/29 14:40
 */
public class Problem_0961_重复N次的元素 {
    public int repeatedNTimes(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return nums[i];

            set.add(nums[i]);
        }

        return -1;
    }
}
