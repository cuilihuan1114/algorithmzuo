import java.util.HashMap;

/**
 * @author cuilihuan
 * @data 2020/11/17 16:28
 */
public class Problem_0001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int other = 0;
        for (int i = 0; i < nums.length; i++) {
            other = target - nums[i];
            if (hashMap.containsKey(other)) {
                return new int[]{hashMap.get(other), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{-1,-1};

    }
}
