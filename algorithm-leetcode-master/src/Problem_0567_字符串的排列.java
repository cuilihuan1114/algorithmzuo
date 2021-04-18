import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/3/21 9:16
 */
public class Problem_0567_字符串的排列 {

    public static void main(String[] args) {
        System.out.println(new Problem_0567_字符串的排列().checkInclusion("abc", "cccccbabbbaaaa"));
    }

    // 时间滑动窗口 就是以左边的位置为起始 这个最长的进行迭代 限制条件为长度all或者字符串当中不存在这个字符 则直接从right开始走下一个
    // 另外用一个cur来判断真个长度 免得进行比较
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null && s2 == null)
            return true;
        if (s1 == null || s2 == null)
            return false;

        int all = s1.length();
        int curAll = all;

        Map<Character, Integer> map = getMap(s1);
        int left = -1;
        int right = 0;
        for (right = 0; right < s2.length(); right++) {
            if (map.containsKey(s2.charAt(right))) {
                int num = map.get(s2.charAt(right));
                if (num > 0) {
                    curAll--;
                }
                map.put(s2.charAt(right), num - 1);
                if (left == -1)
                    left = right;
            } else {

                while (left != -1 && left < right) {
                    map.put(s2.charAt(left), map.get(s2.charAt(left)) + 1);
                    left++;
                }
                left = -1;
                curAll = all;
                continue;
            }

            if (right - left + 1 == all) {
                if (curAll == 0)
                    return true;
                int num = map.get(s2.charAt(left));
                if (num >= 0)
                    curAll++;
                map.put(s2.charAt(left), num + 1);
                left++;
            }
        }
        return false;
    }

    public Map<Character, Integer> getMap(String s1) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            } else
                map.put(s1.charAt(i), 1);
        }
        return map;
    }
}