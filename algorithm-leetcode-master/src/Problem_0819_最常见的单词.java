
import java.util.*;

/**
 * @author cuilihuan
 * @data 2021/5/9 9:23
 */
public class Problem_0819_最常见的单词 {
    public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph == null || paragraph.length() == 0)
            return null;

        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        String[] words = paragraph.split(",| ");
        Map<String, Integer> map = new HashMap<>();
        String curMaxStr = "";
        int curMaxCount = 0;
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            cur = cur.replaceAll(" ", "").replaceAll("\\.","").replaceAll("!","").replaceAll("\\?","").replaceAll(";","").replaceAll("'","");
            cur = cur.toLowerCase();

            if(cur.length() == 0)
                continue;

            if(!bannedSet.contains(cur)){
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                if(map.get(cur) > curMaxCount){
                    curMaxCount = map.get(cur);
                    curMaxStr = cur;
                }
            }
        }
        return curMaxStr;
    }
}
