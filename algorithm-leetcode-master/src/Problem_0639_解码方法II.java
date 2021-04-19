package D0314;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/3/22 9:56
 */
public class Problem_0639_解码方法II {

    public static void main(String[] args) {
        System.out.println(new Problem_0639_解码方法II().numDecodings("2*"));
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int index = 0;
        Map<Integer, Long> map = new HashMap();
        return (int) process(s, index, map);
    }

    private long process(String s, int index, Map<Integer, Long> map) {

        if (map.containsKey(index))
            return map.get(index);
        if (s.length() == index)
            return 1;

        char cur = s.charAt(index);
        long sum = 0;
        if (cur == '*') {
            if (index + 1 == s.length() || s.charAt(index + 1) != '0')
                sum += process(s, index + 1, map) * 9;

            if (index + 1 < s.length()) {
                if (s.charAt(index + 1) == '*') {
                    sum += process(s, index + 2, map) * 15;
                } else if (s.charAt(index + 1) == '0')
                    sum += process(s, index + 2, map) * 2;
                else {
                    int next = s.charAt(index + 1) - '0';
                    sum += process(s, index + 2, map) * (next <= 6 ? 2 : 1);
                }
            }
        } else if (cur == '0') {
            return 0;
        } else {
            sum += process(s, index + 1, map);
            if (index + 1 < s.length())
                if (s.charAt(index + 1) == '*') {
                    if (s.charAt(index) == '1')
                        sum += process(s, index + 2, map) * 9;
                    else if (s.charAt(index) == '2')
                        sum += process(s, index + 2, map) * 6;
                } else if (s.charAt(index) == '1') {
                    sum += process(s, index + 2, map);
                } else if (s.charAt(index) == '2' && s.charAt(index + 1) <= '6')
                    sum += process(s, index + 2, map);

        }

        long ans = sum % ((int) Math.pow(10, 9) + 7);
        map.put(index, ans);
        return ans;
    }
}
