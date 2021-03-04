/**
 * Created by CUI on 2021/3/2
 */
public class Problem_0343_整数拆分 {

    public static void main(String[] args) {
        new Problem_0343_整数拆分().integerBreak(2);
    }

    public int integerBreak(int n) {
        int[] cache = new int[n + 1];
        return process(n, n,cache);
    }

    public int process(int target, int n, int[] cache) {
        if(cache[target] != 0)
            return cache[target];
        int sum = 1;
        int curSum = 1;
        for (int i = 1; i <= target; i++) {
            if (i < n)
                curSum = i * process(target - i, n, cache);
            sum = Math.max(sum, curSum);
        }
        cache[target] = sum;
        return sum;
    }

}
