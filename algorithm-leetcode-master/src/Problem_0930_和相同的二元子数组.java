
import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/5/27 16:46
 */
public class Problem_0930_和相同的二元子数组 {

    public static void main(String[] args) {
        System.out.println(new Problem_0930_和相同的二元子数组().numSubarraysWithSum(new int[]{0, 0, 1}, 0));
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        if(nums == null || nums.length == 0)
            return 0;

        int one = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                one++;
                map.put(one, i);
            }
            dp[i] = one;
        }


        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int cur = dp[i];
            if(cur >= goal){
                int prePos = map.get(cur - goal);
                int pos = i;
                if(cur - goal + 1 <= cur)
                    pos = map.getOrDefault(cur - goal + 1, i);
                ans = ans + (pos - prePos);
            }
        }
        return ans;
    }
}
