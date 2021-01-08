import java.util.HashSet;

/**
 * Created by CUI on 2021/1/8
 */
public class Problem_0211_添加与搜索单词数据结构设计 {

    public static void main(String[] args) {
        Problem_0211_添加与搜索单词数据结构设计 test = new Problem_0211_添加与搜索单词数据结构设计();
        test.addWord("at");
        test.addWord("and");
        test.addWord("an");
        test.addWord("add");
        System.out.println(test.search("a"));
        System.out.println(test.search(".at"));
        test.addWord("bat");
        System.out.println(test.search(".at"));
        System.out.println(test.search("an."));
        System.out.println(test.search("a.d."));
        System.out.println(test.search("b."));
        System.out.println(test.search("a.d"));
        System.out.println(test.search("."));
    }

    class TrieNode {
        TrieNode[] nexts = new TrieNode[26];
        boolean end = false;
    }

    HashSet<String> set = new HashSet<>();
    TrieNode root = new TrieNode();

    /**
     * Initialize your data structure here.
     */
    public Problem_0211_添加与搜索单词数据结构设计() {

    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        if (set.contains(word))
            return;
        set.add(word);
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (cur.nexts[pos] == null)
                cur.nexts[pos] = new TrieNode();
            cur = cur.nexts[pos];
        }
        cur.end = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        if (set.contains(word))
            return true;
        if (word == null || word.length() == 0)
            return false;

        return processSearch(word, 0, root);

    }

    public boolean processSearch(String word, int pos, TrieNode cur) {
        char ch = word.charAt(pos);
        int index = ch - 'a';
        if (ch == '.') {
            for (int j = 0; j < 26; j++) {
                // 在这里一定要注意 要用temp代替cur 防止后面不断的遍历
                TrieNode temp = cur;
                if (temp.nexts[j] != null) {
                    temp = temp.nexts[j];
                    if (pos == word.length() - 1) {
                        if (temp.end)
                            return true;
                    } else if (processSearch(word, pos + 1, temp)) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (cur.nexts[index] == null)
            return false;
        cur = cur.nexts[index];
        if (pos == word.length() - 1)
            return cur.end;
        return processSearch(word, pos + 1, cur);

    }

}
