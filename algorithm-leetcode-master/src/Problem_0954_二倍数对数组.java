
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author cuilihuan
 * @data 2021/6/1 18:39
 */
public class Problem_0954_二倍数对数组 {
    public boolean canReorderDoubled(int[] arr) {
        if (arr == null || arr.length == 0)
            return true;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int ans = map.get(arr[i]);
            if(ans == 0)
                continue;

            map.put(arr[i], ans - 1);
            if(arr[i] < 0){
                if(arr[i] % 2 != 0)
                    return false;
            }
            int tmp = arr[i] < 0 ? arr[i] / 2 : 2 * arr[i];
            if(map.containsKey(tmp) && map.get(tmp) > 0){
                map.put(tmp, map.get(tmp) - 1);
            }else
                return false;
        }
        return true;
    }
}
