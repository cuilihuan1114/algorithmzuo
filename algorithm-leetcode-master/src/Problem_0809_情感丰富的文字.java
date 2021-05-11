
import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/5/10 14:38
 */
public class Problem_0809_情感丰富的文字 {

    public static void main(String[] args) {
        System.out.println(new Problem_0809_情感丰富的文字().expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
    }

    public int expressiveWords(String S, String[] words) {
        if (S == null || S.length() == 0 || words == null || words.length == 0)
            return 0;

        int ans = 0;
        int[] dp = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            dp[i] = (i > 0 ? (S.charAt(i) == S.charAt(i - 1) ? dp[i - 1] + 1 : 1) : 1);
        }

        for (int i = dp.length - 2; i >= 0; i--) {
            if(S.charAt(i) == S.charAt(i+1))
                dp[i] = dp[i + 1];
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (isTransform(S, word, dp)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean isTransform(String s, String word, int[] dp) {
        if (word.length() > s.length())
            return false;
        char pre = '.';
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j == word.length() || s.charAt(i) != word.charAt(j)) {
                if(i == 0)
                    return false;
                if(s.charAt(i) != pre)
                    return false;
                if(dp[i] < 3)
                    return false;

            }else{
                pre = word.charAt(j);
                j++;
            }
        }

        if(j != word.length())
            return false;

        return true;
    }
}
