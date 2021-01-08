import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by CUI on 2021/1/7
 */
public class Problem_0212_单词搜索II {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] s = new String[]{"oath", "pea", "eat", "rain"};
        new Problem_0212_单词搜索II().findWords(board, s);
    }

    //方式二 增加版剪裁
    class TireTreePro {
        TireTreePro[] nexts;
        int end = 0;
        int pass = 0;
        String s;

        public TireTreePro() {
            this.nexts = new TireTreePro[26];
        }
    }

    private TireTreePro getTireRootPro(String[] words) {
        TireTreePro root = new TireTreePro();
        for (int i = 0; i < words.length; i++) {
            TireTreePro cur = root;
            cur.pass++;
            for (int j = 0; j < words[i].length(); j++) {
                int pos = words[i].charAt(j) - 'a';
                if (cur.nexts[pos] == null) {
                    cur.nexts[pos] = new TireTreePro();
                }
                cur = cur.nexts[pos];
                cur.pass++;
            }
            cur.end++;
            cur.s = words[i];
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new LinkedList<>();
        if (board == null || board.length == 0 || words == null || words.length == 0)
            return list;
        TireTreePro root = getTireRootPro(words);
        int N = board.length;
        int M = board[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                proocessPro(board, root, list, i, j);
            }
        }
        return list;
    }

    private int proocessPro(char[][] board, TireTreePro root, List<String> list, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return 0;
        if (root == null || board[i][j] == '0' || root.pass == 0)
            return 0;
        int pos = board[i][j] - 'a';
        int inject = 0;
        if (root.nexts[pos] != null) {
            root = root.nexts[pos];
            if (root.end > 0) {
                list.add(root.s);
                root.end--;
                inject++;
            }
            char temp = board[i][j];
            board[i][j] = '0';
            inject += proocessPro(board, root, list, i + 1, j);
            inject += proocessPro(board, root, list,  i - 1, j);
            inject += proocessPro(board, root, list,  i, j + 1);
            inject += proocessPro(board, root, list, i, j - 1);
            root.pass = root.pass - inject;
            board[i][j] = temp;
        }
        return inject;
    }


    //方式一 剪裁的少
    class TireTree {
        TireTree[] nexts;
        boolean end;
        String s;

        public TireTree() {
            this.nexts = new TireTree[26];
            this.end = false;
        }
    }

    public List<String> findWords1(char[][] board, String[] words) {
        List<String> list = new LinkedList<>();
        if (board == null || board.length == 0 || words == null || words.length == 0)
            return list;
        TireTree root = getTireRoot(words);
        int N = board.length;
        int M = board[0].length;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                proocess(board, root, list, set, i, j);
            }
        }
        return list;
    }

    private void proocess(char[][] board, TireTree root, List<String> list, HashSet<String> set, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        if (root == null || board[i][j] == '0')
            return;
        int pos = board[i][j] - 'a';
        if (root.nexts[pos] != null) {
            root = root.nexts[pos];
            if (root.end && !set.contains(root.s)) {
                list.add(root.s);
                set.add(root.s);
            }
            char temp = board[i][j];
            board[i][j] = '0';
            proocess(board, root, list, set, i + 1, j);
            proocess(board, root, list, set, i - 1, j);
            proocess(board, root, list, set, i, j + 1);
            proocess(board, root, list, set, i, j - 1);
            board[i][j] = temp;
        }
    }


    private TireTree getTireRoot(String[] words) {
        TireTree root = new TireTree();
        for (int i = 0; i < words.length; i++) {
            TireTree cur = root;
            for (int j = 0; j < words[i].length(); j++) {
                int pos = words[i].charAt(j) - 'a';
                if (cur.nexts[pos] == null) {
                    cur.nexts[pos] = new TireTree();
                }
                cur = cur.nexts[pos];
            }
            cur.end = true;
            cur.s = words[i];
        }
        return root;
    }
}
