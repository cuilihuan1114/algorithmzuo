/**
 * @author cuilihuan
 * @data 2020/11/20 14:53
 */
public class Problem_0010_正则表达式匹配 {

    public static void main(String[] args) {
        System.out.println(new Problem_0010_正则表达式匹配().isMatch("aa", "a*"));
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        if (!isValid(str, pattern))
            return false;

        return process4(str, pattern, 0, 0);
    }


    private boolean process4(char[] str, char[] pattern, int si, int pi) {
        if (str.length == si && pattern.length == pi)
            return true;

        if (str.length == si)
            return (pi + 1 < pattern.length && pattern[pi + 1] == '*' && process4(str, pattern, si, pi + 2));

        if (pattern.length == pi) {
            return false;
        }

        if (pi + 1 >= pattern.length || pattern[pi + 1] != '*')
            return ((str[si] == pattern[pi]) || (pattern[pi] == '.')) && process4(str, pattern, si + 1, pi + 1);


        if (((str[si] == pattern[pi]) || pattern[pi] == '.') && process4(str, pattern, si + 1, pi))
            return true;

        return process4(str, pattern, si, pi + 2);
    }

    private boolean isValid(char[] str, char[] pattern) {
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '.' || str[i] == '*')
                return false;
        }

        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] == '*' && (i == 0 || pattern[i - 1] == '*'))
                return false;
        }
        return true;
    }

    private boolean process(char[] str, char[] pattern, int si, int pi) {
        if (si == str.length) {
            if (pi == pattern.length)
                return true;
            if (pi + 1 < pattern.length && pattern[pi + 1] == '*')
                return process(str, pattern, si, pi + 2);
            return false;
        }

        if (pi >= pattern.length)
            return false;

        //pi+1的位置不为*或者pi+1的位置不存在
        if (pi + 1 >= pattern.length || pattern[pi + 1] != '*')
            return ((str[si] == pattern[pi]) || (pattern[pi] == '.')) && process(str, pattern, si + 1, pi + 1);

        //以下的都是pi+1的位置为*
        if (pattern[pi] != '.' && str[si] != pattern[pi])
            return process(str, pattern, si, pi + 2);

        //pi pi+1的位置都跳过 直接到pi+2的位置
        if (process(str, pattern, si, pi + 2))
            return true;

        //str往前走 pi也往前走
        while (si < str.length && (str[si] == pattern[pi] || pattern[pi] == '.')) {
            if (process(str, pattern, si + 1, pi + 2)) {
                return true;
            }
            si++;
        }
        return false;
    }

    //改成记忆化搜索
    public boolean isMatch1(String s, String p) {
        if (s == null || p == null)
            return false;
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        int[][] dp = new int[str.length + 1][pattern.length + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                //1->true 0->false -1->还没遍历过
                dp[i][j] = -1;
            }
        }

        if (!isValid(str, pattern))
            return false;

        return process1(str, pattern, 0, 0, dp);
    }

    private boolean process1(char[] str, char[] pattern, int si, int pi, int[][] dp) {

        if (dp[si][pi] != -1)
            return dp[si][pi] == 1;

        if (si == str.length) {
            if (pi == pattern.length)
                return true;
            if (pi + 1 < pattern.length && pattern[pi + 1] == '*') {
                boolean ans = process1(str, pattern, si, pi + 2, dp);
                dp[si][pi] = ans ? 1 : 0;
                return ans;
            }
            dp[si][pi] = 0;
            return false;
        }

        if (pi >= pattern.length) {
            dp[si][pi] = 0;
            return false;
        }

        //pi+1的位置不为*或者pi+1的位置不存在
        if (pi + 1 >= pattern.length || pattern[pi + 1] != '*') {
            boolean ans = ((str[si] == pattern[pi]) || (pattern[pi] == '.')) && process1(str, pattern, si + 1, pi + 1, dp);
            dp[si][pi] = ans ? 1 : 0;
            return ans;
        }

        //以下的都是pi+1的位置为*
        if (pattern[pi] != '.' && str[si] != pattern[pi]) {
            boolean ans = process1(str, pattern, si, pi + 2, dp);
            dp[si][pi] = ans ? 1 : 0;
            return ans;
        }

        //pi pi+1的位置都跳过 直接到pi+2的位置
        if (process1(str, pattern, si, pi + 2, dp)) {
            dp[si][pi] = 1;
            return true;
        }

        //str往前走 pi也往前走
        while (si < str.length && (str[si] == pattern[pi] || pattern[pi] == '.')) {
            if (process1(str, pattern, si + 1, pi + 2, dp)) {
                dp[si][pi] = 1;
                return true;
            }
            si++;
        }
        dp[si][pi] = 0;
        return false;
    }


    //改成记忆化搜索
    public boolean isMatch3(String s, String p) {
        if (s == null || p == null)
            return false;
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        int[][] dp = new int[str.length + 1][pattern.length + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                //1->true 0->false -1->还没遍历过
                dp[i][j] = -1;
            }
        }

        if (!isValid(str, pattern))
            return false;

        return process2(str, pattern, 0, 0, dp);
    }

    private boolean process2(char[] str, char[] pattern, int si, int pi, int[][] dp) {

        if (dp[si][pi] != -1)
            return dp[si][pi] == 1;

        if (si == str.length) {
            if (pi == pattern.length)
                return true;
            if (pi + 1 < pattern.length && pattern[pi + 1] == '*') {
                boolean ans = process2(str, pattern, si, pi + 2, dp);
                dp[si][pi] = ans ? 1 : 0;
                return ans;
            }
            dp[si][pi] = 0;
            return false;
        }

        if (pi >= pattern.length) {
            dp[si][pi] = 0;
            return false;
        }

        //pi+1的位置不为*或者pi+1的位置不存在
        if (pi + 1 >= pattern.length || pattern[pi + 1] != '*') {
            boolean ans = ((str[si] == pattern[pi]) || (pattern[pi] == '.')) && process2(str, pattern, si + 1, pi + 1, dp);
            dp[si][pi] = ans ? 1 : 0;
            return ans;
        }

        if ((str[si] == pattern[pi] || pattern[pi] == '.') && process2(str, pattern, si + 1, pi, dp)) {
            dp[si][pi] = 1;
            return true;
        }

        if (process2(str, pattern, si, pi + 2, dp)) {
            dp[si][pi] = 1;
            return true;
        }
        dp[si][pi] = 0;
        return false;
    }


    //改成最终的动态规划
    public boolean isMatch4(String s, String p) {
        if (s == null || p == null)
            return false;
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        if (!isValid(str, pattern))
            return false;

        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        dp[str.length][pattern.length] = true;
        for (int i = pattern.length - 1; i >= 0; i--) {
            dp[str.length][i] = (i + 1 < pattern.length && pattern[i + 1] == '*') && dp[str.length][i + 2];
        }

        for (int i = str.length - 1; i >= 0; i--) {
            for (int j = pattern.length - 1; j >= 0; j--) {
                if (j + 1 >= pattern.length || pattern[j + 1] != '*') {
                    dp[i][j] = ((str[i] == pattern[j]) || (pattern[j] == '.')) && dp[i + 1][j + 1];
                } else if ((str[i] == pattern[j] || pattern[j] == '.') && dp[i + 1][j]) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i][j + 2];
                }
            }
        }
        return dp[0][0];
    }
}
