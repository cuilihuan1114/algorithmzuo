package newke;

/**
 * @author cuilihuan
 * @data 2021/3/18 19:44
 */
public class Problem_01 {
    public static void main(String[] args) {
        System.out.println(new Problem_01().process(new int[]{2,2,2}));
    }
    public long process(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (long)(nums[i] - 1) * (long)(i + 1) + 1;

        }
        return sum;
    }
}
