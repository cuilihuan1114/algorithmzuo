
/**
 * @author cuilihuan
 * @data 2021/5/9 15:57
 */
public class Problem_0829_连续整数求和 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {

            System.out.println("i=" + i + ":" + new Problem_0829_连续整数求和().consecutiveNumbersSum(i));
        }
    }

    public int consecutiveNumbersSum(int N) {
        while ((N & 1) == 0) N >>= 1;
        int ans = 1, d = 3;

        while (d * d <= N) {
            int e = 0;
            while (N % d == 0) {
                N /= d;
                e++;
            }
            ans *= e + 1;
            d += 2;
        }

        if (N > 1) ans <<= 1;
        return ans;
    }

    public int consecutiveNumbersSum1(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = i; j <= N; j++) {
                sum += j;
                if (sum == N)
                    count++;
                else if (sum > N)
                    break;
            }
        }
        return count;
    }
}
