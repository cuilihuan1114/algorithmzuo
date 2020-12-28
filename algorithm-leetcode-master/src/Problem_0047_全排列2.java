import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2020/11/28 21:29
 */
public class Problem_0047_全排列2 {

    public static void main(String[] args) {
        System.out.println(new Problem_0047_全排列2().permuteUnique(new int[]{1, 3, 2}).size());
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums==null || nums.length == 0)
            return list;

        process(list, nums, 0);
        return list;
    }

    private void process(List<List<Integer>> list, int[] nums, int index) {
        if(index == nums.length){
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                cur.add(nums[i]);
            }
            list.add(cur);
            return;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                continue;
            }
            hashSet.add(nums[i]);
            swap(nums, index, i);
            process(list,nums,index+1);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int index) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}
