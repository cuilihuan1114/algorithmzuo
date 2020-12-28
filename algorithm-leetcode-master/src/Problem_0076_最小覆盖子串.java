import java.util.HashMap;

/**
 * @author cuilihuan
 * @data 2020/12/5 18:59
 */
public class Problem_0076_最小覆盖子串 {

    public static void main(String[] args) {
        System.out.println(new Problem_0076_最小覆盖子串().minWindow("ADOBECODEBANC", "ABC"));
    }


    public String minWindow(String s, String t) {
        if (s == null || t == null)
            return "";

        HashMap<Character, Integer> map = new HashMap<>();
        int all = 0;
        for (int i = 0; i < t.length(); i++) {
            all++;
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }

        int left = 0;
        int right = 0;
        int minL = -1;
        int minR = -1;
        int min = -1;

        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) >= 0)
                    all--;
            }
            while (all == 0) {
                if (min == -1 || min > right - left + 1) {
                    min = right - left + 1;
                    minL = left;
                    minR = right;
                }
                if (map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if(map.get(s.charAt(left)) > 0)
                        all++;
                }
                left++;
            }
            right++;
        }

        return min == -1 ? "" : s.substring(minL, minR + 1);
    }

}
