/**
 * @author cuilihuan
 * @data 2020/11/28 16:35
 */
public class Problem_0041_缺失的第一个正数 {

    public static void main(String[] args) {
        System.out.println(new Problem_0041_缺失的第一个正数().firstMissingPositive(new int[]{2,2}));
    }

    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 1;
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            if (nums[left] - 1 == left) {
                left++;
            }else if(nums[left] - 1 < left || nums[left] - 1 > right || nums[left] == nums[nums[left]-1]){
                nums[left] = nums[right];
                right--;
            }else{
                int pos = nums[left];
                int num = nums[pos - 1];
                nums[pos - 1] = nums[left];
                nums[left] = num;
            }
        }
        return left + 1;
    }
}
