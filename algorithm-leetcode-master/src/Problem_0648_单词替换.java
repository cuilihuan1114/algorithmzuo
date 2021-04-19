import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/3/22 21:25
 */
public class Problem_0648_单词替换 {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("bat");
        list.add("rat");
        String sentcence = "the cattle was rattled by the battery";
        System.out.println(new Problem_0648_单词替换().replaceWords(list, sentcence));
    }

    class TireNode {
        TireNode[] next = new TireNode[26];
        boolean flag = false;
        String cur = null;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TireNode root = new TireNode();
        getTire(root, dictionary);

        StringBuffer sb = new StringBuffer();
        String[] array = sentence.split(" ");
        for (int i = 0; i < array.length; i++) {
            if (!process(root, sb, array[i], 0)) {
                sb.append(array[i]);
                sb.append(" ");
            }
        }

        return sb.charAt(sb.length() - 1) == ' ' ? sb.substring(0, sb.length() - 1) : sb.toString();

    }

    public boolean process(TireNode root, StringBuffer sb, String sentence, int index) {

        TireNode cur = root;

        for (int i = index; i < sentence.length(); i++) {
            if (cur.next[sentence.charAt(i) - 'a'] != null) {
                cur = cur.next[sentence.charAt(i) - 'a'];
                if (cur.flag) {
                    sb.append(cur.cur);
                    sb.append(" ");
                    return true;
                }
            } else
                return false;
        }

        return false;

    }

    private void getTire(TireNode root, List<String> dictionary) {
        TireNode cur = root;
        for (int i = 0; i < dictionary.size(); i++) {
            cur = root;
            for (int j = 0; j < dictionary.get(i).length(); j++) {
                char charactor = dictionary.get(i).charAt(j);
                if (cur.next[charactor - 'a'] == null)
                    cur.next[charactor - 'a'] = new TireNode();
                cur = cur.next[charactor - 'a'];
            }
            cur.flag = true;
            cur.cur = dictionary.get(i);
        }
    }
}