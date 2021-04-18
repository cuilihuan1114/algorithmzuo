
/**
 * @author cuilihuan
 * @data 2021/4/13 15:30
 */
public class Problem_0795_区间子数组个数 {


    public static void main(String[] args) {
        System.out.println(new Problem_0795_区间子数组个数().numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
    }


    //解法二 用最大值R 减 最大值为L-1的所有连续
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return count(A, R) - count(A, L - 1);
    }

    public int count(int[] A, int bound) {
        int ans = 0, cur = 0;
        for (int x : A) {
            cur = x <= bound ? cur + 1 : 0;
            ans += cur;
        }
        return ans;
    }

    public int numSubarrayBoundedMax1(int[] A, int L, int R) {
        if (A == null || A.length == 0)
            return 0;

        int left = -1;
        int sum = 0;

        for (int right = 0; right < A.length; right++) {
            int cur = A[right];
            if (cur > R) {
                left = right;
            } else {
                int curMax = 0;
                for (int j = right; j > left; j--) {
                    curMax = Math.max(curMax, A[j]);
                    if (curMax >= L) {
                        sum += j - left;
                        break;
                    }
                }
            }
        }
        return sum;
    }
}
