import java.util.Arrays;

/**
     * @author cuilihuan
     * @data 2021/3/19 9:28
     */
    public  class Problem_0462_最少移动次数使数组元素相等2 {
        public int minMoves2(int[] nums) {
            if(nums == null || nums.length == 0)
                return 0;
            Arrays.sort(nums);

            int sum = 0;
            int middle = nums[nums.length / 2];
            for (int i = 0; i < nums.length; i++) {
                sum += Math.abs(middle - nums[i]);
            }
            return sum;
        }
    }