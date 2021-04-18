import java.util.HashMap;

/**
 * @author cuilihuan
 * @data 2021/3/4 10:29
 */
public class Problem_0318_最大单词长度乘积 {
    public int maxProduct(String[] words) {
        if(words == null || words.length == 0)
            return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int bitCount = 0;
            for (int j = 0; j < words[i].length(); j++) {
                bitCount = bitCount | (1 << (words[i].charAt(j) - 'a'));
            }

            if(map.containsKey(bitCount)){
                map.put(bitCount, Math.max(map.get(bitCount), words[i].length()));
            }else
                map.put(bitCount,words[i].length());
        }

        int res = 0;
        for(Integer key1 : map.keySet()){
            for(Integer key2 : map.keySet()){
                if((key1 & key2) == 0){
                    res = Math.max(res, map.get(key1) * map.get(key2));
                }
            }
        }

        return res;

    }
}
