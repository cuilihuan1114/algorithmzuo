import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/4/13 19:18
 */
public class Problem_0796_旋转字符串 {
    public boolean rotateString(String A, String B) {
        if (A == null || B == null)
            return false;

        if (A.length() == 0 && B.length() == 0)
            return true;

        if (A.length() == 0 || B.length() == 0)
            return false;

        if (A.length() != B.length())
            return false;

        List<Integer> pos = new ArrayList<>();
        char cur = B.charAt(0);
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == cur)
                pos.add(i);
        }

        for (int i = 0; i < pos.size(); i++) {
            int p = pos.get(i);
            if (isSame(A, B, p)) {
                return true;
            }
        }

        return false;
    }

    private boolean isSame(String A, String B, int p) {
        int index = 0;
        for (int i = p; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(index)) {
                index++;
                if (index == B.length())
                    index = 0;
            } else
                return false;
        }
        return true;
    }
}