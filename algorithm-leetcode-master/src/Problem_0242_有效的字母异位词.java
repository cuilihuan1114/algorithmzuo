import java.util.HashMap;

/**
 * Created by CUI on 2021/1/10
 */
public class Problem_0242_有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int all = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else
                map.put(c, 1);
            all++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            all--;
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) < 0)
                    return false;
            }else{
                return false;
            }
        }

        return all == 0;
    }
}
