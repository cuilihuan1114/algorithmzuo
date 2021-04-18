import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/4/9 14:57
 */
public class Problem_0745_前缀和后缀搜索 {

    class Tire {
        boolean flag = false;
        Tire[] next = new Tire[26];
        Map<String, Integer> map = new HashMap<>();
    }

    Tire pre = new Tire();
    Tire suff = new Tire();

    public Problem_0745_前缀和后缀搜索(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String s = words[i];

            Tire cur = pre;
            for (int j = 0; j < s.length(); j++) {
                if (cur.next[s.charAt(j) - 'a'] == null)
                    cur.next[s.charAt(j) - 'a'] = new Tire();
                cur = cur.next[s.charAt(j) - 'a'];
                cur.map.put(s, i);
            }

            cur = suff;
            for (int j = s.length() - 1; j >= 0; j--) {
                if (cur.next[s.charAt(j) - 'a'] == null)
                    cur.next[s.charAt(j) - 'a'] = new Tire();
                cur = cur.next[s.charAt(j) - 'a'];
                cur.map.put(s, i);
            }
        }
    }

    public int f(String prefix, String suffix) {
        HashMap<String, Integer> cur = new HashMap<>();
        int max = -1;
        Tire preTire = pre;
        for (int i = 0; i < prefix.length(); i++) {
            if (preTire.next[prefix.charAt(i) - 'a'] != null)
                preTire = preTire.next[prefix.charAt(i) - 'a'];
            else
                return -1;
        }

        Map<String, Integer> preMap = preTire.map;

        Tire suffTire = suff;
        for (int i = suffix.length() - 1; i >= 0; i--) {
            if (suffTire.next[suffix.charAt(i) - 'a'] != null)
                suffTire = suffTire.next[suffix.charAt(i) - 'a'];
            else
                return -1;
        }

        Map<String, Integer> suffMap = suffTire.map;
        for (String key : suffMap.keySet()) {
            if (preMap.containsKey(key)) {
                max = Math.max(max, preMap.get(key));
            }
        }

        return max;

    }
}
