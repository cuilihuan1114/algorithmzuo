/**
 * @author cuilihuan
 * @data 2021/3/6 15:03
 */
public class Problem_0396_旋转函数 {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int cur = 0;
        for (int i = 0; i < A.length; i++) {
            cur += A[i] * i;
            sum += A[i];
        }

        int res = cur;
        for (int i = A.length - 1; i > 0 ; i--) {
            cur += sum;
            cur = cur - A.length * A[i];
            res = Math.max(res, cur);
        }
        return res;
    }
}
