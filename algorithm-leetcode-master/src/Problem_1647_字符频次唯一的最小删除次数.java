import java.util.*;

/**
 * Created by CUI on 2021/2/27
 */
public class Problem_1647_字符频次唯一的最小删除次数 {

    public static void main(String[] args) {
        new Problem_1647_字符频次唯一的最小删除次数().minDeletions("aaabbbcc");
    }

    public int minDeletions(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int[] letterNum = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letterNum[s.charAt(i) - 'a']++;
        }

        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < letterNum.length; i++) {
            int count = letterNum[i];
            if(count > 0){
                while (set.contains(count)){
                    res++;
                    count--;
                }
            }
            if(count > 0)
                set.add(count);
        }
        return res;
    }

}
