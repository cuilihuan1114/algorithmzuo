import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author cuilihuan
 * @data 2021/4/13 15:01
 */
public class Problem_0792_匹配子序列的单词数 {

    public static void main(String[] args) {

        System.out.println(new Problem_0792_匹配子序列的单词数().numMatchingSubseq("qlhxagxdqh", new String[]{"qlhxagxdq", "qlhxagxdq", "lhyiftwtut", "yfzwraahab"}));
    }

    class Node {
        String word;
        int index;

        public Node(String w, int i) {
            word = w;
            index = i;
        }
    }

    // 只需要遍历一次S
    public int numMatchingSubseq(String S, String[] words) {
        int ans = 0;
        ArrayList<Node>[] heads = new ArrayList[26];
        for (int i = 0; i < 26; ++i)
            heads[i] = new ArrayList<Node>();

        for (String word : words)
            heads[word.charAt(0) - 'a'].add(new Node(word, 0));

        for (char c : S.toCharArray()) {
            ArrayList<Node> old_bucket = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<Node>();

            for (Node node : old_bucket) {
                node.index++;
                if (node.index == node.word.length()) {
                    ans++;
                } else {
                    heads[node.word.charAt(node.index) - 'a'].add(node);
                }
            }
            old_bucket.clear();
        }
        return ans;
    }

    //o(n2) 虽然有优化 能过
    public int numMatchingSubseq1(String s, String[] words) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        HashMap<String, Integer> set = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() <= s.length())
                set.put(words[i], set.getOrDefault(words[i], 0) + 1);
        }

        int sum = 0;
        for (String cur : set.keySet()) {
            if (isSub(s, cur, count)) {
                sum += set.get(cur);
            }
        }
        return sum;
    }

    private boolean isSub(String target, String cur, int[] count) {
        int[] exist = new int[26];

        int targetIndex = 0;
        int curIndex = 0;

        if (count[cur.charAt(curIndex) - 'a'] == 0)
            return false;

        while (targetIndex < target.length() && curIndex < cur.length()) {
            if (target.charAt(targetIndex) != cur.charAt(curIndex)) {
                targetIndex++;
            } else {
                int ans = cur.charAt(curIndex) - 'a';
                exist[ans]++;
                if (exist[ans] > count[ans])
                    return false;
                targetIndex++;
                curIndex++;
                if (curIndex < cur.length()) {
                    if (count[cur.charAt(curIndex) - 'a'] == 0)
                        return false;
                }
            }
        }


        return curIndex == cur.length();
    }
}