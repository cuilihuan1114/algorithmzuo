
import java.util.HashSet;

/**
 * @author cuilihuan
 * @data 2021/5/10 10:50
 */
public class Problem_0824_山羊拉丁文 {
    public String toGoatLatin(String S) {
        if(S == null || S.length() == 0)
            return "";

        StringBuffer sb = new StringBuffer();
        String[] sentence = S.split(" ");
        HashSet<Character> set = new HashSet<>();
        set.add('a');set.add('A');
        set.add('e');set.add('E');
        set.add('i');set.add('I');
        set.add('o');set.add('O');
        set.add('u');set.add('U');

        String end = "";
        for (int i = 0; i < sentence.length; i++) {
            String word = sentence[i];
            char c = word.charAt(0);
            if(set.contains(c)){
                word += "ma";
            }else{
                word = word.substring(1) + c + "ma";
            }
            end += 'a';
            word += end;
            if(i != 0)
                sb.append(" ");
            sb.append(word);
        }

        return sb.toString();

    }
}
