import java.util.HashMap;
import java.util.HashSet;

/**
 * @author cuilihuan
 * @data 2021/3/9 19:12
 */
public class Problem_0409_最长回文串 {
    public int longestPalindrome(String s) {
        int size = 0;

        HashSet<Character> map = new HashSet();

        for (int i = 0; i < s.length(); i++) {
            if(map.contains(s.charAt(i))){
                size = size + 2;
                map.remove(s.charAt(i));
            }else{
                map.add(s.charAt(i));
            }
        }

        if(!map.isEmpty())
            size++;

        return size;
    }
}
