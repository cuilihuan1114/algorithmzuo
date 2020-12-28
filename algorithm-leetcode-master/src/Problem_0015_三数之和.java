import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2020/11/21 19:23
 */
public class Problem_0015_三数之和 {
    public static void main(String[] args) {
        new Problem_0015_三数之和().threeSum(new int[]{-1, 0, 1, 2, -1, -4});

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1])
                continue;
            List<List<Integer>> cur = twoSum(nums, i + 1, -nums[i]);
            for (int j = 0; j < cur.size(); j++) {
                cur.get(j).add(nums[i]);
                list.add(cur.get(j));
            }
        }
        return list;
    }

    private List<List<Integer>> twoSum(int[] nums, int index, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        int left = index;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > sum) {
                right--;
            } else if (nums[left] + nums[right] < sum) {
                left++;
            } else {
                if (left - 1 < index || nums[left - 1] != nums[left]) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[left]);
                    cur.add(nums[right]);
                    list.add(cur);
                }
                left++;
            }
        }
        return list;
    }

}
