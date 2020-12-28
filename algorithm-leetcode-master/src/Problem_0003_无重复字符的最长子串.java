/**
 * @author cuilihuan
 * @data 2020/11/18 21:49
 */
public class Problem_0003_无重复字符的最长子串 {
    //abcabcbb
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] string = s.toCharArray();
        //用数组代替map集合 可以减少取的时间
        int[] map = new int[256];
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
        int maxLen = 0;
        int pre = -1;
        for (int i = 0; i < string.length; i++) {
            pre = Math.max(pre, map[string[i] ]);
            maxLen = Math.max(i-pre, maxLen);
            map[string[i]] = i;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_0003_无重复字符的最长子串().lengthOfLongestSubstring("abcabcbb"));
    }
}
