import java.util.HashMap;

/**
 * Created by CUI on 2021/1/5
 */
public class Problem_0128_最长连续序列 {

    public static void main(String[] args) {
        System.out.println(new Problem_0128_最长连续序列().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                continue;
            int preLen = map.containsKey(nums[i] - 1) ? map.get(nums[i] - 1) : 0;
            int nextLen = map.containsKey(nums[i] + 1) ? map.get(nums[i] + 1) : 0;
            int all = preLen + nextLen + 1;
            map.put(nums[i] - preLen, all);
            map.put(nums[i] + nextLen, all);
            map.put(nums[i], all);
            max = Math.max(all, max);
        }
        return max;
    }
}
