
import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/5/30 9:29
 */
public class Problem_0967_连续差相同的数字 {

    public static void main(String[] args) {
        System.out.println(new Problem_0967_连续差相同的数字().numsSameConsecDiff(3, 7));
    }

    public int[] numsSameConsecDiff(int n, int k) {
        if (n == 0)
            return new int[]{};
        List<String> list = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            cur.add(String.valueOf(i));
        }
        process(list, cur, n - 1, k);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.parseInt(list.get(i));
        }
        return res;
    }

    private void process(List<String> list, List<String> cur, int n, int k) {
        if (n == 0) {
            list.addAll(cur);
            return;
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < cur.size(); i++) {
            String s = cur.get(i);
            char pre = s.charAt(s.length() - 1);
            if (pre + k >= '0' && pre + k <= '9') {
                String tmp = s + (char) (pre + k);
                ans.add(tmp);
            }
            if (k != 0 && pre - k >= '0' && pre - k <= '9'){
                String tmp = s + (char) (pre - k);
                ans.add(tmp);
            }
        }
        process(list, ans, n - 1, k);
    }
}
