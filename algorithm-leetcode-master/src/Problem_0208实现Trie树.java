/**
 * Created by CUI on 2021/1/7
 */
public class Problem_0208实现Trie树 {
    class TireNode{
        TireNode[] nexts = new TireNode[26];
        boolean end = false;
        String s = null;
    }

    TireNode root = null;

    /** Initialize your data structure here. */
    public Problem_0208实现Trie树() {
        root = new TireNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TireNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (cur.nexts[pos] == null) {
                cur.nexts[pos] = new TireNode();
            }
            cur = cur.nexts[pos];
        }
        cur.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TireNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if(cur.nexts[pos] == null)
                return false;
            cur = cur.nexts[pos];
        }
        return cur.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TireNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int pos = prefix.charAt(i) - 'a';
            if(cur.nexts[pos] == null)
                return false;
            cur = cur.nexts[pos];
        }
        return true;
    }
}
