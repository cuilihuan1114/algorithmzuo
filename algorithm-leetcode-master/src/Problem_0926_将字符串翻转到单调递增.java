
/**
 * @author cuilihuan
 * @data 2021/5/28 15:18
 */
public class Problem_0926_将字符串翻转到单调递增 {


    public static void main(String[] args) {
        System.out.println(new Problem_0926_将字符串翻转到单调递增().minFlipsMonoIncr("00110"));
    }

    public int minFlipsMonoIncr(String s) {
        if(s == null || s.length() == 0)
            return 0;

        int[] left = new int[s.length()];
        int[] right = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            left[i] = (i == 0) ? 0 : left[i - 1];
            if(s.charAt(i) == '1')
                left[i]++;
        }

        for (int i = s.length() - 1; i >= 0 ; i--) {
            right[i] = (i == s.length() - 1) ? 0 : right[i + 1];
            if(s.charAt(i) == '0')
                right[i]++;
        }

        int ans = left[s.length() - 1];
        for (int i = 0; i < s.length(); i++) {
            ans = Math.min(ans, (i == 0 ? 0 : left[i - 1]) + right[i]);
        }
        return ans;
    }
}
