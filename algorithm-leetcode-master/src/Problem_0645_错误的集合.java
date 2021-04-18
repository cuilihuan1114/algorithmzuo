/**
 * @author cuilihuan
 * @data 2021/3/23 10:56
 */
public class Problem_0645_错误的集合 {
    public int[] findErrorNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != (i + 1)) {
                int temp = nums[i] - 1;
                if (nums[i] == nums[temp])
                    break;
                nums[i] = nums[temp];
                nums[temp] = temp + 1;
            }
        }

        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ans[0] = nums[i];
                ans[1] = i + 1;
                return ans;
            }
        }

        return ans;
    }
}