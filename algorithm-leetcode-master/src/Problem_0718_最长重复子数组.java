
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/4/8 18:42
 */
public class Problem_0718_最长重复子数组 {

    public static void main(String[] args) {

        System.out.println(new Problem_0718_最长重复子数组().findLength(new int[]{0,1,1,1,1}, new int[]{1,0,1,0,1}));
    }

    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        for (int i = 0; i < B.length; i++) {
            if(A[0] == B[i])
                dp[0][i] = 1;

        }

        for (int i = 0; i < A.length; i++) {
            if(B[0] == A[i])
                dp[i][0] = 1;

        }

        int max = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                if(A[i] == B[j])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }










}
