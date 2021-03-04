import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by CUI on 2021/2/28
 */
public class Problem_0345_反转字符串中的元音字母 {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('u');
        set.add('e');
        set.add('o');
        set.add('i');
        set.add('A');
        set.add('U');
        set.add('E');
        set.add('O');
        set.add('I');

        List<Character> list = new ArrayList<>();
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if(set.contains(s.charAt(i))){
                list.add(s.charAt(i));
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0,j=0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))){
                sb.append(list.get(j));
                j++;
            }else
                sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
