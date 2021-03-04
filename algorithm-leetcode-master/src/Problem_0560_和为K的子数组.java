import java.util.HashMap;

/**
 * Created by CUI on 2021/2/27
 */
public class Problem_0560_和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(record.containsKey(sum-k)){
                count += record.get(sum - k);
            }
            if(record.containsKey(sum)){
                record.put(sum, record.get(sum) + 1);
            }else
                record.put(sum, 1);
        }
        return count;
    }
}
