import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/3/24 11:04
 */
public class Problem_0664_奇怪的打印机 {
    public static void main(String[] args) {
        System.out.println(new Problem_0664_奇怪的打印机().strangePrinter("aaaa"));
    }

    int[][] memo;
    public int strangePrinter(String s) {
        int N = s.length();
        memo = new int[N][N];
        return dp(s, 0, N - 1);
    }
    public int dp(String s, int i, int j) {
        if (i > j) return 0;
        if (memo[i][j] == 0) {
            int ans = dp(s, i+1, j) + 1;
            for (int k = i+1; k <= j; ++k)
                if (s.charAt(k) == s.charAt(i))
                    ans = Math.min(ans, dp(s, i, k-1) + dp(s, k+1, j));
            memo[i][j] = ans;
        }
        return memo[i][j];
    }


    public int strangePrinter1(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] array = s.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        return process(array, 0, array.length - 1, 'A', map);
    }

    private int process(char[] array, int start, int end, char preChar, Map<String, Integer> map) {

        String code = getCode(start, end, preChar);
        if (map.containsKey(code))
            return map.get(code);
        if (start == end)
            return array[start] == preChar ? 0 : 1;
        if (start > end)
            return 0;
        int i = start;
        for (; i <= end; i++) {
            if (array[i] != preChar) {
                break;
            }
        }
        if (i == end + 1)
            return 0;
        start = i;
        char cur = array[start];
        int max = Integer.MAX_VALUE;
        int curMax = 0;
        for (i = start; i <= end; i++) {
            if (array[i] == cur) {
                int p1 = process(array, start + 1, i - 1, cur, map);
                int p2 = process(array, i + 1, end, preChar, map);
                curMax = p1 + p2 + 1;
                max = Math.min(max, curMax);
            }
        }
        map.put(code, max);
        return max;
    }

    private String getCode(int start, int end, char preChar) {
        return start + "_" + end + "_" + preChar;
    }
}
