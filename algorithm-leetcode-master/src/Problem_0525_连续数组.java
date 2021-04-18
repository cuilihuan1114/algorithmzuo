import java.util.HashMap;
import java.util.Map;

/**
     * @author cuilihuan
     * @data 2021/3/20 14:42
     */
    public  class Problem_0525_连续数组 {
        public int findMaxLength(int[] nums) {
            if(nums == null || nums.length == 0)
                return 0;

            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            map.put(0, -1);
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += (nums[i] == 1 ? 1 : -1);
                if(map.containsKey(sum)){
                    max = Math.max(max, i - map.get(sum));
                }else
                    map.put(sum, i);
            }
            return max;
        }
    }