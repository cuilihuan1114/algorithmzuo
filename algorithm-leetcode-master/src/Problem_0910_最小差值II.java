
import java.util.Arrays;

/**
 * @author cuilihuan
 * @data 2021/5/27 11:03
 */
public class Problem_0910_最小差值II {

    public static void main(String[] args) {
        System.out.println(new Problem_0910_最小差值II().smallestRangeII(new int[]{1, 3, 6}, 3));
    }

    public int smallestRangeII(int[] A, int K) {
        int N = A.length;
        Arrays.sort(A);
        int ans = A[N-1] - A[0];

        for (int i = 0; i < A.length - 1; ++i) {
            int a = A[i], b = A[i+1];
            int high = Math.max(A[N-1] - K, a + K);
            int low = Math.min(A[0] + K, b - K);
            ans = Math.min(ans, high - low);
        }
        return ans;


    }
}
