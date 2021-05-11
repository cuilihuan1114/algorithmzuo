
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/5/9 19:05
 */
public class Problem_0811_子域名访问计数 {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0)
            return list;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String word = cpdomains[i];
            String[] s = word.split(" ");
            int num = Integer.parseInt(s[0]);
            String[] split = s[1].split("\\.");
            String res = "";
            for (int j = split.length - 1; j >= 0; j--) {
                if (j != split.length - 1)
                    res = "." + res;
                res = split[j] + res;
                map.put(res, map.getOrDefault(res, 0) + num);
            }
        }

        for(String key : map.keySet()){
            int value = map.get(key);
            list.add(value + " " + key);
        }
        return list;
    }
}
