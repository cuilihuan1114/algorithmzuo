
import java.util.HashSet;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/5/9 9:55
 */
public class Problem_0820_单词的压缩编码 {

    public static void main(String[] args) {
        System.out.println(new Problem_0820_单词的压缩编码().minimumLengthEncoding(new String[]{
                "time", "time", "time", "time"}));
    }

    class Tire {
        Tire[] next = new Tire[26];
        boolean end = false;
        boolean hasNext = false;
        String s = null;

    }

    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length == 0)
            return 0;

        HashSet<String> removeSame = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            removeSame.add(words[i]);
        }
        Tire root = new Tire();
        HashSet<String> set = new HashSet<>();
        for (String word : removeSame) {
            Tire cur = root;
            for (int j = word.length() - 1; j >= 0; j--) {
                if (cur.next[word.charAt(j) - 'a'] == null)
                    cur.next[word.charAt(j) - 'a'] = new Tire();
                else if (cur.next[word.charAt(j) - 'a'].end) {
                    set.remove(cur.next[word.charAt(j) - 'a'].s);
                    cur.end = false;
                }
                cur.hasNext = true;
                cur = cur.next[word.charAt(j) - 'a'];

            }
            if (!cur.hasNext) {
                cur.end = true;
                cur.s = word;
                cur.hasNext = true;
                set.add(word);
            }
        }

        int count = 0;
        for (String key : set)
            count += key.length();
        count += set.size();
        return count;
    }

}
