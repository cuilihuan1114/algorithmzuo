
/**
 * @author cuilihuan
 * @data 2021/5/28 14:56
 */
public class Problem_0922_按奇偶排序数组II {
    public int[] sortArrayByParityII(int[] nums) {
        if(nums == null || nums.length == 0)
            return nums;

        int[] res = new int[nums.length];
        int even = 0;
        int order = 1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0){
                res[even] = nums[i];
                even += 2;
            }else{
                res[order] = nums[i];
                order += 2;
            }
        }

        return res;
    }
}
