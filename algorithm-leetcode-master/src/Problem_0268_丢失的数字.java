/**
 * Created by CUI on 2021/1/1
 */
public class Problem_0268_丢失的数字 {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            if(nums[left] == left)
                left++;
            else if(nums[left] < left || nums[left] > right || nums[nums[left]] == nums[left]){
                nums[left] = nums[right];
                right--;
            }else{
                int pos = nums[left];
                nums[left] = nums[pos];
                nums[pos] = pos;
            }

        }
        return left;
    }
}
