import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/3/18 9:59
 */
public class Problem_0500_键盘行 {

    public static void main(String[] args) {
        System.out.println(new Problem_0500_键盘行().findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"}).length);
    }


    public String[] findWords(String[] words) {
        String[] s = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};

        HashSet<Character>[] sets = new HashSet[s.length];
        for (int i = 0; i < s.length; i++) {
            sets[i] = new HashSet();
            for (int j = 0; j < s[i].length(); j++) {
                sets[i].add(s[i].charAt(j));
            }
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            boolean flag = true;
            int pre = 0;
            for (int j = 0; j < cur.length(); j++) {
                char character = cur.charAt(j);
                if(character >= 'A' && character <='Z')
                    character = (char)(character - 'A' + 'a');
                int k = 0;

                for (k = 0; k < sets.length; k++) {
                    if(sets[k].contains(character))
                        break;
                }

                if(j == 0){
                    pre = k;
                }else if(pre != k || k == sets.length){
                    flag = false;
                    break;
                }
            }
            if(flag)
                list.add(cur);
        }

        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
