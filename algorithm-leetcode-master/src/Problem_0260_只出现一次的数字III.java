/**
 * Created by CUI on 2021/1/12
 */
public class Problem_0260_只出现一次的数字III {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }

        int first = 0;
        int onepos = xor & (~xor + 1);

        for (int i = 0; i < nums.length; i++) {
            if((nums[i] & onepos) != 0){
                first = first ^ nums[i];
            }
        }

        return new int[]{first, first ^ xor};

    }
}
