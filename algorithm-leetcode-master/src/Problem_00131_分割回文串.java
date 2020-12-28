import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2020/12/23 20:06
 */
public class Problem_00131_分割回文串 {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();

        boolean[][] dp = getDP(s);

        process(s, dp, 0, list, path);
        return list;
    }

    private void process(String s, boolean[][] dp, int start, List<List<String>> list, LinkedList<String> path) {
        if (start == s.length()) {
            list.add(copy(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                path.addLast(s.substring(start, end + 1));
                process(s, dp, end + 1, list, path);
                path.removeLast();
            }
        }
    }

    private List<String> copy(LinkedList<String> path) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < path.size(); i++) {
            list.add(path.get(i));
        }
        return list;
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
