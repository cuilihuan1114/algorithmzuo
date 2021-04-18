import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/4/13 19:07
 */
public class Problem_0791_自定义字符串排序 {
    public String customSortString(String S, String T) {
        if (S == null)
            return T;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            map.put(T.charAt(i), map.getOrDefault(T.charAt(i), 0) + 1);
        }

        StringBuffer sb = new StringBuffer();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < S.length(); i++) {
            if (map.containsKey(S.charAt(i))) {
                int num = map.get(S.charAt(i));
                for (int j = 0; j < num; j++) {
                    sb.append(S.charAt(i));
                }
                set.add(S.charAt(i));
            }
        }

        for (Character key : map.keySet()) {
            if (!set.contains(key)) {
                int num = map.get(key);
                for (int j = 0; j < num; j++) {
                    sb.append(key);
                }
            }
        }

        return sb.toString();
    }
}
