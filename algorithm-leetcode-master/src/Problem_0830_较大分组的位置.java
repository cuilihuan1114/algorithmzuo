
import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/5/11 9:40
 */
public class Problem_0830_较大分组的位置 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();
        if (s == null || s.length() == 0)
            return list;

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                start = end = 0;
            } else {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    end++;
                } else {
                    if (end - start + 1 >= 3) {
                        List<Integer> cur = new ArrayList<>();
                        cur.add(start);
                        cur.add(end);
                        list.add(cur);
                    }
                    start = end = i;
                }
            }
        }

        if (end - start + 1 >= 3) {
            List<Integer> cur = new ArrayList<>();
            cur.add(start);
            cur.add(end);
            list.add(cur);
        }
        return list;
    }
}
