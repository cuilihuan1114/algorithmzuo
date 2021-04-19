
import java.util.HashMap;

/**
 * @author cuilihuan
 * @data 2021/3/28 9:27
 */
public class Problem_0697_数组的度 {
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else
                map.put(nums[i], 1);
            max = Math.max(max, map.get(nums[i]));
        }

        int len = Integer.MAX_VALUE;
        HashMap<Integer, Integer> pos = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!pos.containsKey(nums[i])) {
                pos.put(nums[i], i);
            }

            if (count.containsKey(nums[i])) {
                count.put(nums[i], count.get(nums[i]) + 1);
            } else
                count.put(nums[i], 1);

            if (count.get(nums[i]) == max) {
                len = Math.min(len, i - pos.get(nums[i]) + 1);
            }
        }

        return len;
    }
}