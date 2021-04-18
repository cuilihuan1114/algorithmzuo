/**
 * @author cuilihuan
 * @data 2021/3/18 14:51
 */
public class Problem_0485_最大连续1的个数 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int max = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
               cur++;
            }else{
                max = Math.max(max, cur);
                cur = 0;
            }
        }
        return Math.max(max, cur);
    }
}
