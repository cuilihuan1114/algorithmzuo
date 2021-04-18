import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/3/4 11:07
 */
public class Problem_0336_回文对 {
    class TireNode {
        boolean end = false;
        TireNode[] next = new TireNode[26];
        int pos = -1;
    }


    public static void main(String[] args) {
        new Problem_0336_回文对().palindromePairs(new String[]{
                "abcd", "dcba", "lls", "s", "sssll"});
    }




    public List<List<Integer>> palindromePairs(String[] words) {
        TireNode root = new TireNode();
        getTire(root, words);
        TireNode cur = root;

        List<List<Integer>> list = new ArrayList<>();
        int blank = -1;
        for (int i = 0; i < words.length; i++) {
            if(words[i].length() == 0)
                blank = i;
        }

        for (int i = 0; i < words.length  && blank!=-1; i++) {
            if(i != blank && isValid(words[i],0,words[i].length()-1)){
                List<Integer> curList = new ArrayList<>();
                curList.add(i);
                curList.add(blank);
                list.add(curList);

                curList = new ArrayList<>();
                curList.add(blank);
                curList.add(i);
                list.add(curList);
            }
        }

//        HashMap<String, String> map = new HashMap<>();
//        for (int i = 0; i < words.length; i++) {
//            map.put(words[i], new StringBuffer(words[i]).reverse().toString());
//        }
        for (int i = 0; i < words.length; i++) {
            cur = root;
            for (int j = 0; j < words[i].length(); j++) {
                int rightId = isExists(cur, words[i], 0, j);
                if (rightId != -1 && isValid(words[i], j + 1, words[i].length()-1) && i != rightId) {
                    List<Integer> curList = new ArrayList<>();
                    curList.add(i);
                    curList.add(rightId);
                    list.add(curList);
                }

                int leftId = isExists(cur,words[i], j , words[i].length() - 1);
                if (j > 0  && leftId != -1 && isValid(words[i], 0, j-1) && i != leftId) {
                    List<Integer> curList = new ArrayList<>();
                    curList.add(leftId);
                    curList.add(i);
                    list.add(curList);
                }
            }
        }
        return list;


    }

    private int isExists(TireNode cur, String word, int start, int end) {
        for (int k = end; k >= start ; k--) {
            int pos = word.charAt(k) - 'a';
            if(cur.next[pos] != null){
                cur = cur.next[pos];
            }else
                return -1;
        }
        return cur.end ? cur.pos : -1;
    }

    private boolean isValid(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    private void getTire(TireNode root, String[] words) {
        TireNode cur = root;
        for (int i = 0; i < words.length; i++) {
            cur = root;
            for (int j = 0; j < words[i].length(); j++) {
                int pos = words[i].charAt(j) - 'a';
                if (cur.next[pos] == null) {
                    cur.next[pos] = new TireNode();
                }
                cur = cur.next[pos];
            }
            cur.end = true;
            cur.pos = i;
        }
    }
}
