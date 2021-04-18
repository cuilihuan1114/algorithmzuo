/**
 * @author cuilihuan
 * @data 2021/3/16 9:34
 */
public class Problem_0479_最大回文数乘积 {

    public static void main(String[] args) {
        System.out.println(new Problem_0479_最大回文数乘积().largestPalindrome(2));
    }

    public int largestPalindrome(int n) {
        if (n == 1)
            return 9;
        long min = (long) Math.pow(10, n - 1);
        long max = (long) Math.pow(10, n);
        long ans = 0;
        long big = ((long) Math.pow(10, n) - 1) * ((long) Math.pow(10, n ) - 1);
        for (long i = max ; i >= min; i--) {
            ans = getHuiWen(i);
            if (ans > big)
                continue;
            long sqrt = (long) Math.sqrt(ans);
            for (long j = max; j >= sqrt; j--) {
                if (ans % j == 0) {
                    System.out.println(ans + " " + j);
                    return (int) (ans % 1337);
                }
            }
        }
        return 0;

    }

    private long getHuiWen(long i) {
        StringBuilder s = new StringBuilder(String.valueOf(i));
        String cur = i + s.reverse().toString();
        return Long.parseLong(cur);
    }
}
