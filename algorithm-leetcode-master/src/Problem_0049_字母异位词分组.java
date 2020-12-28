import java.util.*;

/**
 * @author cuilihuan
 * @data 2020/11/29 17:52
 */
public class Problem_0049_字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }
        for (List<String> value : map.values()) {
            list.add(value);
        }
        return list;
    }




    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] record = new int[26];
            for (int i = 0; i < str.length(); i++) {
                record[str.charAt(i) - 'a']++;
            }
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < record.length; i++) {
                s.append((char) (i + 'a')).append(record[i]).append("_");
            }
            if (!map.containsKey(s.toString())) {
                map.put(s.toString(), new ArrayList<>());
            }
            map.get(s.toString()).add(str);
        }
        for (List<String> value : map.values()) {
            list.add(value);
        }
        return list;
    }
}
