import java.util.*;

/**
 * @author cuilihuan
 * @data 2021/3/25 21:42
 */
public class Problem_0679_24点游戏 {


    public static void main(String[] args) {
        System.out.println(new Problem_0679_24点游戏().judgePoint24(new int[]{1, 2, 1, 2}));
    }

    public boolean judgePoint24(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        List<Double> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add((double) nums[i]);
        }

        return process(list);

    }

    private boolean process(List<Double> list) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (i == j)
                        continue;
                    List<Double> cur = new ArrayList<>();

                    for (int k = 0; k < list.size(); k++) {
                        if (k != i && k != j)
                            cur.add(list.get(k));
                    }

                    double ans = 0;
                    for (int k = 0; k < 4; k++) {
                        if (k == 0) { // +
                            ans = list.get(i) + list.get(j);
                        } else if (k == 1) { //  /
                            ans = list.get(i) / list.get(j);
                        } else if (k == 2) { // *
                            ans = list.get(i) * list.get(j);
                        } else { // -
                            ans = list.get(i) - list.get(j);
                        }

                        if (cur.size() == 0) {
                            // 注意这里需要注意的是double类型
                            if (Math.abs(ans - 24) <= 1e-6) {
                                return true;
                            }
                        }
                        cur.add(ans);
                        if (process(cur)) {
                            return true;
                        }
                        cur.remove(cur.size() - 1);
                    }
                }
            }
        return false;
    }

}
