import java.util.HashSet;

/**
 * Created by CUI on 2021/1/7
 */
public class Problem_0217_存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return false;
            }
            set.add(nums[i]);
        }
        return true;
    }
}
