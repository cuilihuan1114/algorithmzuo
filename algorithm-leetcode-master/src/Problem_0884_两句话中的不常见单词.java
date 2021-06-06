
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/5/26 16:36
 */
public class Problem_0884_两句话中的不常见单词 {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Integer> map1 = new HashMap<>();
        String[] array2 = s2.split(" ");
        for (int i = 0; i < array2.length; i++) {
            map1.put(array2[i], map1.getOrDefault(array2[i], 0) + 1);
        }


        String[] array1 = s1.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < array1.length; i++) {
            map.put(array1[i], map.getOrDefault(array1[i], 0) + 1);
        }
        List<String> list = new ArrayList<>();

        for(String key : map.keySet()){
            if(map.get(key) == 1 && !map1.containsKey(key))
                list.add(key);
        }


        for(String key : map1.keySet()){
            if(map1.get(key) == 1 && !map.containsKey(key))
                list.add(key);
        }

        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;

    }
}
