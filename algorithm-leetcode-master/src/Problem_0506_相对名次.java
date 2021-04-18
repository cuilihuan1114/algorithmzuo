import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/3/18 14:42
 */
public class Problem_0506_相对名次 {
    public String[] findRelativeRanks(int[] score) {
        if(score == null || score.length == 0)
            return null;
        String[] res = new String[score.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }

        Arrays.sort(score);

        int count = 4;
        int num = 0;
        for (int i = score.length - 1; i >= 0; i--) {
            int pos = map.get(score[i]);
            num++;
            if(num == 1){
                res[pos] = "Gold Medal";
            }else if(num == 2){
                res[pos] = "Silver Medal";
            }else if(num == 3)
                res[pos] = "Bronze Medal";
            else {
                res[pos] = count + "";
                count++;
            }
        }
        return res;
    }
}
