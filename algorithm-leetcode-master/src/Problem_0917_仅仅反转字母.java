
/**
 * @author cuilihuan
 * @data 2021/5/28 14:49
 */
public class Problem_0917_仅仅反转字母 {
    public String reverseOnlyLetters(String s) {
        if(s == null || s.length() == 0)
            return "";

        StringBuffer sb = new StringBuffer();
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i)<='Z'))
                sb.append(s.charAt(i));
        }

        StringBuffer ans = new StringBuffer();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i)<='Z'))
                ans.append(sb.charAt(j++));
            else
                ans.append(s.charAt(i));
        }

        return ans.toString();
    }
}
