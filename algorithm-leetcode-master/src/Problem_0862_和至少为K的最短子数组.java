
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author cuilihuan
 * @data 2021/5/24 10:30
 */
public class Problem_0862_和至少为K的最短子数组 {

    public static void main(String[] args) {
        System.out.println(new Problem_0862_和至少为K的最短子数组().shortestSubarray(new int[]{17, 85, 93, -45, -21}, 150));
    }

    public int shortestSubarray(int[] A, int K) {
        int N = A.length;
        long[] P = new long[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + (long) A[i];

        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N+1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList(); //opt(y) candidates, as indices of P

        for (int y = 0; y < P.length; ++y) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, y - monoq.removeFirst());

            monoq.addLast(y);
        }

        return ans < N+1 ? ans : -1;
    }



    public int shortestSubarray2(int[] A, int K) {
        int sum = 0, result = Integer.MAX_VALUE;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, -1);
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            Map.Entry<Integer, Integer> floorEntry = map.floorEntry(sum - K);
            if (floorEntry != null && i - floorEntry.getValue() < result)
                result = i - floorEntry.getValue();
            while (map.size() > 0 && map.lastKey() > sum) map.pollLastEntry();
            map.put(sum, i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }


    // 超时 假的二分法
    public int shortestSubarray1(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }

        int ans = -1;
        int start = 1;
        int end = nums.length;
        while (start <= end) {
            int middle = (start + end) / 2;
            int res = getExist(nums, middle, dp, k);
            if (res != -1) {
                ans = res;
                end = middle - 1;
            } else {
                res = getExist(nums, start, dp, k);
                if (res != -1)
                    return res;
                start = start + 1;
            }
        }

        return ans;

    }

    private int getExist(int[] nums, int middle, int[] dp, int target) {
        int ans = -1;
        for (int i = middle - 1; i < nums.length; i = i + 1) {
            if (i == middle - 1) {
                if (dp[i] >= target)
                    return middle;
            } else {
                if (dp[i] - dp[i - middle] >= target)
                    return middle;
            }
        }
        return ans;
    }
}
