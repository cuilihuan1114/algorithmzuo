
import java.util.HashSet;

/**
 * @author cuilihuan
 * @data 2021/5/8 14:15
 */
public class Problem_0804_唯一摩尔斯密码词 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] revert = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String ans = words[i];
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < ans.length(); j++) {
                sb.append(revert[ans.charAt(j) - 'a']);
            }
            set.add(sb.toString());
        }

        return set.size();

    }
}
