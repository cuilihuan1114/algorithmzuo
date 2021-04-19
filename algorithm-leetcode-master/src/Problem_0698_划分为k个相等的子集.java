
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author cuilihuan
 * @data 2021/3/26 18:55
 */
public class Problem_0698_划分为k个相等的子集 {

    public static void main(String[] args) {

        System.out.println(new Problem_0698_划分为k个相等的子集().canPartitionKSubsets(new int[]{2, 2, 2, 2, 3, 4, 5}, 4));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) return false;
        int averge = sum / k;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > averge)
                return false;
        }


        Arrays.sort(nums);
        int index = 0;
        HashMap<String, Boolean> map = new HashMap<>();
        return process1(nums, averge, index, sum, map);
    }

    private boolean process1(int[] nums, int target, int used, int todo, HashMap<String, Boolean> map) {

        String code = getHash(todo, used);
        if (map.containsKey(code))
            return map.get(code);

        // 一定要注意括号括号括号括号括号===================
        if (used == ((1 << nums.length) - 1))
            return true;

        int ans = (todo - 1) % target + 1;
        for (int i = 0; i < nums.length; i++) {
            if ((((used >> i) & 1) == 0) && nums[i] <= ans) {
                if (process1(nums, target, (used | (1 << i)), todo - nums[i], map)) {
                    map.put(code, true);
                    return true;
                }
            }
        }
        map.put(code, false);
        return false;
    }

    private String getHash(int curSum, int index) {
        return curSum + "_" + index;
    }

    public boolean canPartitionKSubsets1(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) return false;
        int averge = sum / k;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > averge)
                return false;
        }

        Arrays.sort(nums);
        return process(nums, averge, new int[k], nums.length - 1);
    }

    private boolean process(int[] nums, int averge, int[] count, int index) {
        if (index < 0)
            return true;

        for (int i = 0; i < count.length; i++) {
            if (count[i] + nums[index] <= averge) {
                count[i] += nums[index];
                if (process(nums, averge, count, index - 1))
                    return true;
                count[i] -= nums[index];
            }
            if (count[i] == 0)
                break;
        }

        return false;
    }
}