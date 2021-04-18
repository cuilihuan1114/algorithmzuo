import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/3/20 15:35
 */
public class Problem_0524_通过删除字母匹配到字典里最长单词 {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length() == 0 ? o1.compareTo(o2) : o2.length() - o1.length();
            }
        });

        for (int i = 0; i < dictionary.size(); i++) {
            if (isSame(s, dictionary.get(i)))
                return dictionary.get(i);
        }

        return "";
    }

    private boolean isSame(String s, String target) {
        int j = 0;
        for (int i = 0; i < s.length() && j < target.length(); i++) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
        }
        return j == target.length();
    }
}