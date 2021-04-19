
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/4/17 16:49
 */
public class Problem_0761_特殊的二进制序列 {
    public String makeLargestSpecial(String S) {
        if (S == null || S.length() == 0)
            return "";

        return process(S);
    }

    private String process(String S) {
        StringBuffer sb = new StringBuffer();
        List<String> list = new ArrayList<>();
        int cnt = 0;
        int pos = 0;
        for (int i = 0; i < S.length(); i++) {
            cnt += (S.charAt(i) == '1' ? 1 : -1);
            if (cnt == 0) {
                list.add('1' + process(S.substring(pos + 1, i))+ '0');
                pos = i + 1;

            }
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
