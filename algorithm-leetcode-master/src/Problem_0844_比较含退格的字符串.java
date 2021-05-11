
/**
 * @author cuilihuan
 * @data 2021/5/11 14:11
 */
public class Problem_0844_比较含退格的字符串 {
    public boolean backspaceCompare(String s, String t) {
        if (s == null || t == null)
            return false;
        if (s.length() == 0 && t.length() == 0)
            return true;

        String ans1 = getOperate(s);
        String ans2 = getOperate(t);
        if(ans1.equals(ans2))
            return true;
        return false;
    }

    private String getOperate(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (sb.length() != 0)
                    sb.deleteCharAt(sb.length() - 1);
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
