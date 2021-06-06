
import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/5/27 14:26
 */
public class Problem_0916_单词子集 {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] res = new int[26];
        for (int i = 0; i < words2.length; i++) {
            String s = words2[i];
            int[] count = getWords(s);
            for (int j = 0; j < res.length; j++) {
                res[j] = Math.max(res[j], count[j]);
            }
        }

        for (int i = 0; i < words1.length; i++) {
            String s = words1[i];
            int[] result = new int[26];
            for (int j = 0; j < s.length(); j++) {
                result[s.charAt(j) - 'a']++;
            }
            if(isContains(result,res)){
                ans.add(s);
            }
        }

        return ans;
    }

    private int[] getWords(String s) {
        int[] ans = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ans[s.charAt(i) - 'a']++;
        }
        return ans;
    }

    // 超时了 多算了
    public List<String> wordSubsets1(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < words2.length; i++) {
            String s = words2[i];
            int[] res = new int[26];
            for (int j = 0; j < s.length(); j++) {
                res[s.charAt(j) - 'a']++;
            }
            list.add(res);
        }

        for (int i = 0; i < words1.length; i++) {
            String s = words1[i];
            int[] res = new int[26];
            for (int j = 0; j < s.length(); j++) {
                res[s.charAt(j) - 'a']++;
            }

            boolean flag = true;
            for (int j = 0; j < list.size(); j++) {
                if(!isContains(res,list.get(j))){
                    flag = false;
                    break;
                }
            }
            if(flag)
                ans.add(s);
        }

        return ans;

    }

    private boolean isContains(int[] res, int[] target) {
        for (int i = 0; i < res.length; i++) {
            if(target[i] > res[i])
                return false;
        }
        return true;
    }
}
