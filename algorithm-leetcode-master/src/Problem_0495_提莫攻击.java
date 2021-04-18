/**
 * @author cuilihuan
 * @data 2021/3/18 10:29
 */
public class Problem_0495_提莫攻击 {
    public static void main(String[] args) {
        System.out.println(new Problem_0495_提莫攻击().findPoisonedDuration(new int[]{1, 4}, 2));
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0)
            return 0;

        int start = timeSeries[0];
        int end = start + duration - 1;
        int sum = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] <= end) {
                end = timeSeries[i] - 1;
            }

            sum += end - start + 1;

            start = timeSeries[i];
            end = start + duration - 1;
        }
        sum += (end - start) + 1;
        return sum;
    }
}
