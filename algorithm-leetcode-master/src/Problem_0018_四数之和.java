import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2020/11/21 21:44
 */
public class Problem_0018_四数之和 {
    public static void main(String[] args) {
        System.out.println(new Problem_0018_四数之和().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0).size());
    }



    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }


        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(i-1<0 || nums[i] != nums[i-1]){
                List<List<Integer>> cur = threeSum(nums, i + 1, target-nums[i]);
                for (int j = 0; j < cur.size(); j++) {
                    cur.get(j).add(nums[i]);
                    list.add(cur.get(j));
                }
            }
        }
        return list;
    }

    private List<List<Integer>> threeSum(int[] nums, int index, int target) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = index; i < nums.length; i++) {
            if (i - 1 < index || nums[i] != nums[i - 1]) {
                List<List<Integer>> cur = twoSum(nums, i + 1, target-nums[i]);
                for (int j = 0; j < cur.size(); j++) {
                    cur.get(j).add(nums[i]);
                    list.add(cur.get(j));
                }
            }
        }
        return list;
    }

    private List<List<Integer>> twoSum(int[] nums, int index, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int left = index;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            }else{
                if (left - 1 < index || nums[left] != nums[left - 1]) {
                    List<Integer> cur = new ArrayList<Integer>();
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
