
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/5/26 14:08
 */
public class Problem_0890_查找和替换模式 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();

        if (words == null || words.length == 0)
            return ans;

        for (int i = 0; i < words.length; i++) {
            String res = words[i];
            if (res.length() != pattern.length())
                continue;

            HashMap<Character, Character> map = new HashMap<>();
            HashSet<Character> set = new HashSet<>();
            boolean flag = false;
            for (int j = 0; j < res.length(); j++) {
                char cur = res.charAt(j);
                if (map.containsKey(cur) ) {
                    if(map.get(cur) != pattern.charAt(j)) {
                        flag = true;
                        break;
                    }
                }else{
                    if(set.contains(pattern.charAt(j))){
                        flag = true;
                        break;
                    }
                    map.put(cur, pattern.charAt(j));
                    set.add(pattern.charAt(j));
                }
            }

            if(!flag)
                ans.add(res);

        }

        return ans;
    }
}
