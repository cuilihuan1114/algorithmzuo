import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/3/14 14:35
 */
public class Problem_0472_连接词 {

    public static void main(String[] args) {
        System.out.println(new Problem_0472_连接词().findAllConcatenatedWordsInADict(new String[]{"a", "b", "ab", "abc"}).size());
    }

    class TireNode {
        TireNode[] next = new TireNode[26];
        boolean flag = false;
    }


    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list = new ArrayList<>();
        if (words == null || words.length == 0)
            return list;
//        Arrays.sort(words, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });

        TireNode root = new TireNode();
        insertTire(root, words);

        for (int i = 0; i < words.length; i++) {
            if(words[i].length() == 0)
                continue;
            char[] array = words[i].toCharArray();
            if (process(array, root, 0, 0))
                list.add(words[i]);
        }
        return list;

    }

    private boolean process(char[] str, TireNode root, int index, int count) {
        if (index == str.length)
            return count > 1;
        TireNode cur = root;
        for (int i = index; i < str.length; i++) {
            if(cur.next[str[i] - 'a'] == null)
                return false;
            cur = cur.next[str[i] - 'a'];
            if(cur.flag){
                if (process(str, root, i + 1, count + 1)) {
                    return true;
                }
            }
        }
        return false;
    }


//    private boolean process(char[] str, TireNode root, int index, int count) {
//        if (index == str.length)
//            return count > 1;
//        for (int i = index; i < str.length; i++) {
//            if (getWord(str, root, index, i) && process(str, root, i + 1, count + 1)) {
//                return true;
//            }
//        }
//        return false;
//    }

    private boolean getWord(char[] str, TireNode root, int start, int end) {
        TireNode cur = root;
        for (int i = start; i <= end; i++) {
            if (cur.next[str[i] - 'a'] == null)
                return false;
            cur = cur.next[str[i] - 'a'];
        }
        return cur.flag;
    }

    private void insertTire(TireNode root, String[] words) {
        TireNode cur = root;
        for (int i = 0; i < words.length; i++) {
            char[] array = words[i].toCharArray();
            cur = root;
            for (int j = 0; j < array.length; j++) {
                if (cur.next[array[j] - 'a'] == null)
                    cur.next[array[j] - 'a'] = new TireNode();
                cur = cur.next[array[j] - 'a'];
            }
            cur.flag = true;
        }

    }
}
