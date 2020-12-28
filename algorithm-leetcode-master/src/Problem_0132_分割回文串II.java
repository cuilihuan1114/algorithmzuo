/**
 * @author cuilihuan
 * @data 2020/12/23 20:32
 */
public class Problem_0132_分割回文串II {
    public static void main(String[] args) {
        System.out.println(new Problem_0132_分割回文串II().minCut1("ababababababababababababcbabababababababababababa"));
        System.out.println(new Problem_0132_分割回文串II().minCut("aab"));
    }

    public int minCut1(String s) {
        if (s == null || s.length() == 0)
            return 0;
        boolean[][] dp = getDP(s);
        int[] cache = new int[s.length()];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }
        int p  = process1(s, dp, 0,cache);

        return p == Integer.MAX_VALUE ? 0 : p - 1;
    }

    private int process1(String s, boolean[][] dp, int start,int[] cache) {
        if (start == s.length()) {
            return 0;
        }

        if(cache[start] != -1)
            return cache[start];

        int p = Integer.MAX_VALUE;
        int cur = 0;
        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                cur = process1(s, dp, end + 1,cache);
                if(cur!=Integer.MAX_VALUE)
                    p = Math.min(p, cur + 1);
            }
        }
        cache[start] = p;
        return p;
    }

    //根据131进行修改 时间超过
    public int minCut(String s) {
        if (s == null || s.length() == 0)
            return 0;
        boolean[][] dp = getDP(s);
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        process(s, dp, 0, 0, min);
        return min[0] - 1;
    }

    private void process(String s, boolean[][] dp, int start, int cur, int[] min) {
        if (start == s.length()) {
            min[0] = Math.min(min[0], cur);
            return;
        }
        cur += 1;
        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                process(s, dp, end + 1, cur,min);
            }
        }
    }

    private boolean[][] getDP(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < dp.length - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = i + 2; j < dp[i].length; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }
        return dp;
    }
}
