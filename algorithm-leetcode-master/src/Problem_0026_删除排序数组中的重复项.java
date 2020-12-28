/**
 * @author cuilihuan
 * @data 2020/11/29 21:33
 */
public class Problem_0026_删除排序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
           if(nums[i] == nums[i-1])
               continue;
            nums[++left] = nums[i];
        }
        return left+1;
    }
}
