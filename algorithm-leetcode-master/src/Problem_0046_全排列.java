import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2020/11/28 21:03
 */
public class Problem_0046_全排列 {
    public static void main(String[] args) {

    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null && nums.length == 0)
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

        for (int i = index; i < nums.length; i++) {
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
