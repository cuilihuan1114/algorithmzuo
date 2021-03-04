import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by CUI on 2021/2/27
 */
public class Problem_0438_找到字符串中所有字母异位词 {

    public static void main(String[] args) {
        new Problem_0438_找到字符串中所有字母异位词().findAnagrams("cbaebabacd",
                "abc");
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<>();

        int all = p.length();
        int[] record = new int[26];
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            if (map.containsKey(p.charAt(i))) {
                map.put(p.charAt(i), map.get(p.charAt(i)) + 1);
            } else
                map.put(p.charAt(i), 1);
        }

        int left = 0;
        int right = 0;
        int other = 0;
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                record[s.charAt(right) - 'a']++;
                if (record[s.charAt(right) - 'a'] <= map.get(s.charAt(right))) {
                    all--;
                } else
                    other++;
            } else
                other++;

            while (all == 0) {
                if (other == 0) {
                    list.add(left);
                }
                if (map.containsKey(s.charAt(left))) {
                    record[s.charAt(left) - 'a']--;
                    if (record[s.charAt(left) - 'a'] < map.get(s.charAt(left))) {
                        all++;
                    } else
                        other--;
                } else
                    other--;
                left++;
            }
            right++;
        }
        return list;
    }
}
