/**
 * @author cuilihuan
 * @data 2021/3/18 9:02
 */
public class Problem_0459_重复的子字符串 {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0)
            return false;

        for (int i = 1; i * 2 <= s.length(); i++) {
            if (s.length() % i == 0) {
                boolean flag = true;
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    return true;
            }
        }

        return false;

    }


}
