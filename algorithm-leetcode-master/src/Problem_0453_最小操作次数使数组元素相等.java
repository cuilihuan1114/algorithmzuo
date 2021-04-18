/**
 * @author cuilihuan
 * @data 2021/3/17 9:40
 */
public class Problem_0453_最小操作次数使数组元素相等 {
    public int minMoves(int[] nums) {
        return  process(nums);
    }

    private int process(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i], min);
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] - min);
        }
        return count;
    }

}
