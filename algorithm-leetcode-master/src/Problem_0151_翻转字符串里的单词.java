import java.util.ArrayList;
import java.util.List;

/**
 * Created by CUI on 2021/1/6
 */
public class Problem_0151_翻转字符串里的单词 {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (word.length() != 0) {
                    list.add(word.toString());
                    word = new StringBuilder();
                }
            } else {
                word.append(s.charAt(i));
            }
        }
        if (word.length() != 0) {
            list.add(word.toString());
        }
        StringBuilder newS = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            newS.append(list.get(i));
            if (i != 0)
                newS.append(" ");
        }
        return newS.toString();
    }
}
