
import java.util.Arrays;

/**
 * @author cuilihuan
 * @data 2021/6/1 15:34
 */
public class Problem_0977_有序数组的平方 {
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;
        int[] ans = new int[nums.length];
        int left = 0;
        int end = nums.length - 1;
        int pos = nums.length - 1;
        while (left <= end){
            if(nums[left] * nums[left] > nums[end] * nums[end]){
                ans[pos--] = nums[left] * nums[left];
                left++;
            }else{
                ans[pos--] = nums[end] * nums[end];
                end--;
            }
        }

        return ans;
    }

    public int[] sortedSquares1(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);
        return nums;

    }
}
