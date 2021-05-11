
/**
 * @author cuilihuan
 * @data 2021/5/8 19:05
 */
public class Problem_0806_写字符串需要的行数 {
    public int[] numberOfLines(int[] widths, String s) {
        int[] ans = new int[2];
        if(s == null || s.length() == 0)
            return ans;

        int remain  = 100;
        for (int i = 0; i < s.length(); i++) {
            if(widths[s.charAt(i) - 'a'] <= remain)
                remain = remain - widths[s.charAt(i) - 'a'];
            else{
                ans[0]++;
                remain = 100  - widths[s.charAt(i) - 'a'];;
            }
        }
        ans[1] = 100 - remain;
        return ans;
    }
}
