/**
 * @author cuilihuan
 * @data 2021/3/23 11:09
 */
public class Problem_0643_子数组最大平均数I {
    public double findMaxAverage(int[] nums, int k) {
        double ans = 0;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = sum / k;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum / k);
        }
        return max;
    }
}