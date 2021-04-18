import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/4/13 14:00
 */
public class Problem_0767_重构字符串 {

    public static void main(String[] args) {
        System.out.println(new Problem_0767_重构字符串().reorganizeString("aaab"));
    }

    public String reorganizeString(String S) {
        int[] count = new int[26];
        int max = 0;
        int cur = 0;

        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i) - 'a']++;
            if (count[S.charAt(i) - 'a'] > max) {
                max = count[S.charAt(i) - 'a'];
                cur = S.charAt(i) - 'a';
            }
        }

        if (max > (S.length() - max) + 1)
            return "";

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (i != cur) {
                int num = count[i];
                for (int j = 0; j < num; j++) {
                    list.add(i);
                }
            }
        }

        String[] res = new String[max];
        for (int i = 0; i < res.length; i++) {
            res[i] = (char) (cur + 'a') + "";
        }

        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            char c = (char) (list.get(i) + 'a');
            res[index] = res[index] + c;
            index++;
            if (index == res.length)
                index = 0;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]);
        }

        return sb.toString();
    }
}