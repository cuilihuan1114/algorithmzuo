import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/3/14 8:59
 */
public class Problem_0474_一和零 {

    public static void main(String[] args) {
        //["1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0",
        // "1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0",
        // "1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0",
        // "1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0",
        // "1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0",
        // "1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0",
        // "1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0",
        // "1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0",
        // "1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0","1","0"]
        //30
        //30
        System.out.println(new Problem_0474_一和零().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    //对应的动态规划

    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0)
            return 0;

        int N = 0;

        int[][] count = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            int[] cur = getCount(strs[i]);
            if (cur[0] <= m && cur[1] <= n) {
                count[N][0] = cur[0];
                count[N][1] = cur[1];
                N++;
            }
        }

        int[][][] dp = new int[N + 1][m + 1][n + 1];

        int pos = 0;

        for (int index = N - 1; index >= 0 ; index--) {
            for (int curZero = m; curZero >= 0 ; curZero--) {
                int max = 0;

                for (int curOne = n; curOne >= 0; curOne--) {
                    if (count[index][0] + curZero <= m && count[index][1] + curOne <= n) {
                        pos = dp[index + 1][curZero + count[index][0]][curOne + count[index][1]];
                        max = pos + 1;
                    }
                    pos = dp[index + 1][curZero][curOne];
                    max = Math.max(max, pos);
                    dp[index][curZero][curOne] = max;

                }
            }
        }
        return dp[0][0][0];
    }



    public int findMaxForm3(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0)
            return 0;

        int N = 0;

        int[][] count = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            int[] cur = getCount(strs[i]);
            if (cur[0] <= m && cur[1] <= n) {
                count[N][0] = cur[0];
                count[N][1] = cur[1];
                N++;
            }
        }

        int[] sum = new int[1];
        int[][][] dp = new int[N + 1][m + 1][n + 1];
        int res = process(count, N, m, n, 0, 0, 0, dp, sum);
        System.out.println(sum[0]);
        return res;
    }

    private int process(int[][] count, int N, int m, int n, int index, int curZero, int cureOne, int[][][] dp, int[] sum) {
        if (index == N)
            return 0;
        if (dp[index][curZero][cureOne] >= 1)
            return dp[index][curZero][cureOne];
        int max = 0;
        int pos = 0;
        if (count[index][0] + curZero <= m && count[index][1] + cureOne <= n) {
            pos = process(count, N, m, n, index + 1, curZero + count[index][0], cureOne + count[index][1], dp, sum);
            max = pos + 1;
        }

        if (max == (m + n - cureOne - curZero) || max == (m + n - cureOne - curZero - 1)) {
            dp[index][curZero][cureOne] = max;
            return max;
        }

        pos = process(count, N, m, n, index + 1, curZero, cureOne, dp, sum);
        max = Math.max(max, pos);
        dp[index][curZero][cureOne] = max;
        return max;
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0)
            return 0;

        int N = 0;

        int[][] count = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            int[] cur = getCount(strs[i]);
            if (cur[0] <= m && cur[1] <= n) {
                count[N][0] = cur[0];
                count[N][1] = cur[1];
                N++;
            }
        }

        Map<String, Integer> map = new HashMap<>();

        int res = process1(count, N, m, n, 0, 0, 0, map);
        return res;
    }

    private int process1(int[][] count, int N, int m, int n, int index, int curZero, int cureOne, Map<String, Integer> map) {
        if (index == N)
            return 0;
        String spe = getSpe(index, curZero, cureOne);
        if (map.containsKey(spe))
            return map.get(spe);
        int max = 0;
        int pos = 0;
        if (count[index][0] + curZero <= m && count[index][1] + cureOne <= n) {
            pos = process1(count, N, m, n, index + 1, curZero + count[index][0], cureOne + count[index][1], map);
            max = pos + 1;
        }
        pos = process1(count, N, m, n, index + 1, curZero, cureOne, map);
        max = Math.max(max, pos);
        map.put(spe, max);
        return max;
    }

    private String getSpe(int index, int curZero, int curOne) {
        return "i" + index + "z" + curZero + "o" + curOne;
    }


    public int findMaxForm1(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0)
            return 0;

        int N = 0;

        int[][] count = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            int[] cur = getCount(strs[i]);
            if (cur[0] <= m && cur[1] <= n) {
                count[N][0] = cur[0];
                count[N][1] = cur[1];
                N++;
            }
        }

        Map<String, Integer> map = new HashMap<>();
        int[] sum = new int[1];

        int res = findMaxForm(count, N, m, n, 0, 0, 0, map, sum);
        return res == -1 ? 0 : res;
    }

    private int findMaxForm(int[][] count, int N, int m, int n, int index, int curZero, int curOne, Map<String, Integer> map, int[] sum) {
        sum[0]++;
        if (index == N)
            return 0;

        String spe = getSpe(index, curZero, curOne);
        if (map.containsKey(spe))
            return map.get(spe);

        int max = -1;
        int pos = -1;
        boolean flag = false;
        for (int i = index; i < N; i++) {
            if (count[i][0] + curZero <= m && count[i][1] + curOne <= n) {
                flag = true;
                pos = findMaxForm(count, N, m, n, i + 1, curZero + count[i][0], curOne + count[i][1], map, sum);
                if (pos != -1) {
                    max = Math.max(pos, max);
                }

                if (pos == N - (i + 1) || pos == (m - curZero + n - curOne)) {
                    break;
                }
            }
        }

        if (max != -1)
            max = max + 1;
        else if (flag)
            max = 1;

        map.put(spe, max);
        return max;
    }


    private int[] getCount(String str) {
        int zero = 0;
        int one = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                zero++;
            else
                one++;
        }
        return new int[]{zero, one};
    }
}
