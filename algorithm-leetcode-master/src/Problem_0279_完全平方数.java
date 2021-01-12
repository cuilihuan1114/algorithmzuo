/**
 * Created by CUI on 2021/1/10
 */
public class Problem_0279_完全平方数 {

    public static void main(String[] args) {
        System.out.println(new Problem_0279_完全平方数().numSquares(55));
    }

    public int numSquares(int n) {
        int[] cache = new int[n + 1];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -2;
        }
        int result = process(n, cache);
        return result == -1 ? 0 : result;
    }

    private int process(int n, int[] cache) {
        if (cache[n] != -2)
            return cache[n];
        if (n == 0)
            return 0;
        int min = -1;
        for (int i = 1; i * i <= n; i++) {
            int cur = n - i * i;
            int asn = process(cur, cache);
            if (asn != -1)
                min = min == -1 ? asn + 1 : Math.min(min, asn + 1);
        }
        cache[n] = min;
        return cache[n];
    }
}
