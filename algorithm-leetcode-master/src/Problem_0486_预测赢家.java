/**
 * @author cuilihuan
 * @data 2021/3/18 10:53
 */
public class Problem_0486_预测赢家 {


    public static void main(String[] args) {
        System.out.println(new Problem_0486_预测赢家().PredictTheWinner(new int[]{1, 3, 1}));
    }

    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int start = 0;
        int end = nums.length - 1;
        int[][] cache = new int[nums.length + 1][nums.length + 1];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                cache[i][j] = -1;
            }
        }

        int res = first(nums, start, end, cache);

        return res >= (sum - res);
    }

    private int first(int[] nums, int start, int end, int[][] cache) {
        int max = 0;

        if (start > end)
            return 0;

        if (cache[start][end] != -1)
            return cache[start][end];

        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }

        max = Math.max(max, sum - first(nums, start + 1, end, cache));

        max = Math.max(max, sum - first(nums, start, end - 1, cache));

        cache[start][end] = max;
        return max;
    }


}
