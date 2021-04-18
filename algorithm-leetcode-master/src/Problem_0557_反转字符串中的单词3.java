/**
 * @author cuilihuan
 * @data 2021/3/21 16:16
 */
public class Problem_0557_反转字符串中的单词3 {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0)
            return "";
        String[] arrays = s.split(" ");
        String[] ans = new String[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            StringBuffer sb = new StringBuffer(arrays[i]);
            ans[i] = sb.reverse().toString();
        }

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < ans.length; i++) {
            res.append(ans[i]);
            if(i != ans.length - 1)
                res.append(" ");
        }

        return res.toString();
    }
}
