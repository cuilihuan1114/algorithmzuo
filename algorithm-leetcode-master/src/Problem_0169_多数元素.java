/**
 * Created by CUI on 2021/1/6
 */
public class Problem_0169_多数元素 {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int cur = nums[0];
        int HP = 1;
        for (int i = 1; i < nums.length; i++) {
            if(HP == 0){
                cur = nums[i];
                HP++;
            }else if (nums[i] != cur) {
                HP--;
            }else
                HP++;
        }
        return cur;
    }
}
