/**
 * @author cuilihuan
 * @data 2020/12/23 19:36
 */
public class Problem_0136_只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int eor = 0;
        for (int i = 0; i < nums.length; i++) {
            eor = eor ^ nums[i];
        }
        return eor;
    }
}
