import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/3/9 19:26
 */
public class Problem_0442_数组中重复的数据 {

    public static void main(String[] args) {
        System.out.println(new Problem_0442_数组中重复的数据().findDuplicates(new int[]{2,1}));
    }
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return list;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] !=  nums[i]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i] ;
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1)
                list.add(nums[i]);
        }
        return list;

    }
}
