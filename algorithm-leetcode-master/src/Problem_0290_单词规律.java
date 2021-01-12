import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by CUI on 2021/1/10
 */
public class Problem_0290_单词规律 {
    public boolean wordPattern(String pattern, String s) {
        String[] string = s.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            if(map.containsKey(pattern.charAt(i))){
                if(i >= s.length() || !map.get(pattern.charAt(i)).equals(string[i]))
                    return false;
            }else{
                if(set.contains(string[i]))
                    return false;
                set.add(string[i]);
                map.put(pattern.charAt(i), string[i]);
            }
        }
        return pattern.length() == string.length;
    }
}
