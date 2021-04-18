/**
 * @author cuilihuan
 * @data 2021/3/19 14:44
 */
public class Problem_0483_最小好进制 {
    public String smallestGoodBase(String n) {
        long N = Long.parseLong(n);
        for (int m = 59; m > 1; m--) {
            long k = (long) Math.pow(N, 1.0 / m);
            //不存在1进制，如果k<=1，直接下一次
            if (k <= 1)
                continue;
            long s = 0;
            for (int i = 0; i <= m; i++)
                s = s * k + 1;
            if (s == N)
                return String.valueOf(k);
        }
        return String.valueOf(N - 1);
    }
}