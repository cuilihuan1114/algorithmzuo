
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author cuilihuan
 * @data 2021/5/29 15:21
 */
public class Problem_0957_N天后的牢房 {

    public static void main(String[] args) {
        System.out.println(new Problem_0957_N天后的牢房().prisonAfterNDays(new int[]{1,1,0,1,1,0,1,1}, 6));
    }


    public int[] prisonAfterNDays(int[] cells, int n) {
        if (cells == null || cells.length == 0)
            return cells;
        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0;
        int[] ans = new int[cells.length];
        String res = "";
        int pos = 0;
        int j = 0;
        for (; j < n; j++) {
            for (int i = 0; i < cells.length; i++) {
                if (i == 0)
                    ans[i] = 0;
                else if (i == cells.length - 1)
                    ans[i] = 0;
                else {
                    if ((cells[i - 1] == 1 && cells[i + 1] == 1) || (cells[i - 1] == 0 && cells[i + 1] == 0))
                        ans[i] = 1;
                    else
                        ans[i] = 0;
                }
            }
            String code = getCode(ans);
            if (map.containsKey(code)) {
                pos = map.get(code);
                System.out.println(index);
                break;
            } else {
                map.put(code, ++index);
                map1.put(index, code);
            }
            cells = ans;
            ans = new int[cells.length];
        }

        if(j == n)
            return cells;

        int remainder = (n - pos + 1 - 1) % (index - pos + 1) + 1;
        res = map1.get(remainder + pos - 1);

        int k = 0;
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.charAt(k) - '0';
            k += 2;
        }

        return ans;

    }

    private String getCode(int[] ans) {
        String res = "";
        for (int i = 0; i < ans.length; i++) {
            res = res + ans[i] + "_";
        }
        return res;
    }
}
