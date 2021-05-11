
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/5/11 20:27
 */
public class Problem_0859_亲密字符串 {
    public boolean buddyStrings(String a, String b) {
        if(a == null || b == null)
            return false;
        if(a.length() != b.length())
            return false;
        if(a.length() == 0 || a.length() == 1)
            return false;


        int first = -1;
        int second = -1;
        HashSet<Character> set = new HashSet<>();
        boolean flag = false;

        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)){
                if(first == -1)
                    first = i;
                else if(second == -1)
                    second = i;
                else
                    return false;
            }
            if(set.contains(a.charAt(i)))
                flag = true;
            set.add(a.charAt(i));
        }

        if(first == -1){
            return flag;
        }


        if(second == -1)
            return false;

        if(a.charAt(first) == b.charAt(second) && a.charAt(second) == b.charAt(first))
            return true;

        return false;

    }
}
