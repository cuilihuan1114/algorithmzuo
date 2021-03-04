/**
 * Created by CUI on 2021/3/1
 */
public class Problem_0312_戳气球 {
    public int maxCoins(int[] nums) {
        int[] array = new int[nums.length + 2];
        array[0] = 1;
        array[nums.length + 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            array[i + 1] = nums[i];
        }


        int[][] cache = new int[array.length][array.length];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                cache[i][j] = -1;
            }

        }
        return process(array, 0, array.length - 1,cache);
    }

    private int process(int[] array, int left, int right, int[][] cache) {
        int sum = 0;
        if(cache[left][right] != -1)
            return cache[left][right];
        int cur = 0;
        for (int i = left + 1; i < right; i++) {
            sum = array[left] * array[right] * array[i];
            sum += process(array, left, i, cache);
            sum += process(array, i, right, cache);
            cur = Math.max(cur, sum);
        }
        cache[left][right] = cur;
        return cur;

    }
}
