import java.util.HashMap;

/**
 * @author cuilihuan
 * @data 2021/3/5 15:26
 */
public class Problem_0395_至少有K个重复字符的最长子串 {

    public static void main(String[] args) {
        System.out.println(new Problem_0395_至少有K个重复字符的最长子串().longestSubstring("baaabcb", 3));
    }

    public int longestSubstring(String s, int k) {
        return process(s, k);

    }

    public int process(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }


        int max = 0;
        int left = 0;
        int right = 0;

        HashMap<Character, Integer> curMap = new HashMap<>();
        int count = 0;
        while (right < s.length()) {

            if (map.get(s.charAt(right)) < k) {
                //递归下去 当成新的字符串再来继续
                max = Math.max(max, process(s.substring(left, right), k));
                count = 0;
                curMap = new HashMap<>();
                left = right + 1;
                right = left;
                continue;
            }

            if (curMap.containsKey(s.charAt(right))) {
                int num = curMap.get(s.charAt(right));
                if (num < k)
                    count--;

                curMap.put(s.charAt(right), num + 1);
            } else {
                curMap.put(s.charAt(right), 1);
                count += k - 1;
            }
            right++;

            if (count == 0)
                max = Math.max(max, right - left);
        }

        return max;

    }
}
