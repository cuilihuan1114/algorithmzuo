import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/3/21 16:48
 */
public class Problem_0594_最长和谐子序列 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else
                map.put(nums[i], 1);
        }

        int max = 0;
        for(Integer key : map.keySet()){
            if(map.containsKey(key+1))
                max = Math.max(max,map.get(key) + map.get(key + 1));
        }

        return max;
    }
}
