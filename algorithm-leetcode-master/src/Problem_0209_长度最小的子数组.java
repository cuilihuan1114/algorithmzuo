import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by CUI on 2021/1/7
 */
public class Problem_0209_长度最小的子数组 {
    public static void main(String[] args) {
        System.out.println(new Problem_0209_长度最小的子数组().minSubArrayLen(15
                , new int[]{1,2,3,4,5}));

    }

    //利用滑动窗口算法
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int left = -1; //(}
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= s) {
                min = Math.min(min, right - left);
                left++;
                sum -= nums[left];
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    //时间复杂度为N*lgN
    public int minSubArrayLen1(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // 必不可少 防止出现全选 如 15 1 2 3 4 5
        map.put(0, -1);
        int min = Integer.MAX_VALUE;
        int pre = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = nums[i] + pre;
            if (cur - s >= 0 && map.floorKey(cur - s) != null) {
                int pos = map.floorEntry(cur - s).getValue();
                min = Math.min(i - pos, min);
            }
            map.put(cur, i);
            pre = cur;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
