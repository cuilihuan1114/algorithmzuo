package D0422;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author cuilihuan
 * @data 2021/4/18 20:17
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        String t = input.next();

        int num = input.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            int sIndex = input.nextInt();
            int tIndex = input.nextInt();
            System.out.println(process(s, t, sIndex - 1, tIndex - 1,map));
        }
    }

    private static int process(String s, String t, int sIndex, int tIndex, Map<String, Integer> map) {
        String code = sIndex + "_" + tIndex;;
        if(map.containsKey(code))
            return map.get(code);

        if(sIndex == s.length()){
            map.put(code, t.length() - tIndex);
            return t.length() - tIndex;
        }
        if(tIndex == t.length()) {
            map.put(code,-1);
            return -1;
        }
        int max = -1;
        if(s.charAt(sIndex) < t.charAt(tIndex)){
            int res = s.length() - sIndex + t.length() - tIndex;
            map.put(code, res);
            return res;
        }else{
            int p1 = process(s, t, sIndex + 1, tIndex, map);
            max = Math.max(max, p1);
            int p2 = process(s, t, sIndex, tIndex + 1, map);
            max = Math.max(max, p2);
        }
        map.put(code, max);
        return max;
    }
}
