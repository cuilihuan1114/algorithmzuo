/**
 * Created by CUI on 2021/1/9
 */
public class Problem_0238_除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int sum = 0;
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                sum *= nums[i];
            else
                zero++;
        }
        int[] ans = new int[nums.length];
        if (zero > 1)
            return ans;
        for (int i = 0; i < ans.length; i++) {
            if(zero == 1){
                if(nums[i] == 0)
                    ans[i] = sum;
                else
                    ans[i] = 0;
            }else{
                ans[i] = sum / nums[i];
            }
        }
        return ans;
    }
}
