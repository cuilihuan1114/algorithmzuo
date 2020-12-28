/**
 * @author cuilihuan
 * @data 2020/11/24 20:32
 */
public class Problem_0044_通配符匹配 {
    public static void main(String[] args) {
        new Problem_0044_通配符匹配().isMatch("", "?");
    }

    public boolean isMatch1(String s, String p) {
        if (s == null && p == null)
            return true;
        if (s == null || p == null)
            return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        for (int i = p.length()-1; i >=0  ; i--) {
            if (p.charAt(i) == '*') {
                dp[s.length()][i] =  dp[s.length()][i + 1];
                continue;
            }
            dp[s.length()][i] = false;
        }


        for (int si = s.length() - 1; si >=0 ; si--) {
            for (int pi = p.length() - 1; pi >=0 ; pi--) {
                if (p.charAt(pi) != '?' && p.charAt(pi) != '*') {
                    dp[si][pi] = p.charAt(pi) == s.charAt(si) && dp[si + 1][pi + 1];
                }else  if (p.charAt(pi) == '?') {
                    dp[si][pi] = dp[si + 1][pi + 1];
                }else if (p.charAt(pi) == '*') {
                    dp[si][pi] =  dp[si + 1][pi] || dp[si][pi + 1];
                }else
                    dp[si][pi] = false;
            }
        }
        return dp[0][0];
    }





    public boolean isMatch(String s, String p) {
        if (s == null && p == null)
            return true;
        if (s == null || p == null)
            return false;
        //0 表示没设置 1表示true -1表示false
        int[][] result = new int[s.length() + 1][p.length() + 1];
        return process(s, p, 0, 0, result);
    }

    private boolean process(String s, String p, int si, int pi, int[][] result) {
        if (result[si][pi] != 0)
            return result[si][pi] == 1;

        if (s.length() == si) {
            if (p.length() == pi) {
                result[si][pi] = 1;
                return true;
            }
            if (p.charAt(pi) == '*') {
                boolean flag = process(s, p, si, pi + 1, result);
                result[si][pi] = flag ? 1 : -1;
                return flag;
            }
            result[si][pi] = -1;
            return false;
        }
        if (p.length() == pi) {
            result[si][pi] = -1;
            return false;
        }

        if (p.charAt(pi) != '?' && p.charAt(pi) != '*') {
            boolean flag = p.charAt(pi) == s.charAt(si) && process(s, p, si + 1, pi + 1, result);
            result[si][pi] = flag ? 1 : -1;
            return flag;
        }

        if (p.charAt(pi) == '?') {
            boolean flag = process(s, p, si + 1, pi + 1, result);
            result[si][pi] = flag ? 1 : -1;
            return flag;
        }
        if (p.charAt(pi) == '*') {
            boolean flag = process(s, p, si + 1, pi, result) || process(s, p, si, pi + 1, result);
            result[si][pi] = flag ? 1 : -1;
            return flag;
        }
        result[si][pi] = -1;
        return false;
    }


}
