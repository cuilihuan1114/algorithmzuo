import java.util.*;

/**
 * Created by CUI on 2021/2/26
 */
public class Problem_0763_划分字母区间 {

    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        if (S == null || S.length() == 0)
            return list;

        int[] count = new int[26];
        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i) - 'a'] = i;
        }
        
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, count[S.charAt(i) - 'a']);
            if (i == end) {
                list.add(end - start+1);
                start = end + 1;
            }
        }
        return list;
    }


}
