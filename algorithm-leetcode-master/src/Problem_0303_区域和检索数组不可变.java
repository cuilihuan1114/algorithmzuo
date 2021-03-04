import java.util.HashMap;

/**
 * Created by CUI on 2021/2/28
 */
public class Problem_0303_区域和检索数组不可变 {
    HashMap<Integer, Integer> map = new HashMap<>();
    public Problem_0303_区域和检索数组不可变(int[] nums) {
        int sum = 0;
        map.put(-1, 0);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(i, sum);
        }
    }

    public int sumRange(int i, int j) {
        return map.get(j) - map.get(i - 1);
    }
}
