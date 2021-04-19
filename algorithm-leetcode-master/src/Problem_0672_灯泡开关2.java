import java.util.HashSet;

/**
 * @author cuilihuan
 * @data 2021/3/25 10:17
 */
public class Problem_0672_灯泡开关2 {

    public static void main(String[] args) {
        for (int n = 1; n <= 5; n++) {
            for (int m = 1; m <= 11; m++) {
                System.out.println("n=" + n + " m=" + m + " " + new Problem_0672_灯泡开关2().flipLights(n, m));
            }
        }
        int n = 4, m = 15;
        System.out.println("n=" + n + " m=" + m + " " + new Problem_0672_灯泡开关2().flipLights(n, m));

    }

    public int flipLights(int n, int m) {
        if (m == 0) return 1;
        if (n == 0) return 0;
        if (n == 1) return 2;
        if (n == 2) return m == 1 ? 3 : 4;
        if (m == 1) return 4;
        if (m == 2) return 7;
        return 8;
    }

    public int flipLights1(int n, int m) {
        if (m == 0) return 1;
        HashSet<String> set = new HashSet<>();
        int[] flag = new int[n];
        process(flag, 0, m, set);
        return set.size();
    }

    private void process(int[] flag, int index, int m, HashSet<String> set) {
        if (index == m) {
            String code = getCode(flag);
            if (!set.contains(code))
                set.add(code);
            return;
        }

        process(getOp1(flag), index + 1, m, set);
        process(getOp2(flag), index + 1, m, set);
        process(getOp3(flag), index + 1, m, set);
        process(getOp4(flag), index + 1, m, set);
    }

    private String getCode(int[] flag) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < flag.length; i++) {
            sb.append(flag[i]);
            sb.append("_");
        }
        return sb.toString();
    }

    private int[] getOp4(int[] flag) {
        int[] ans = new int[flag.length];
        for (int i = 0; i < flag.length; i++) {
            if (i % 3 == 0)
                ans[i] = flag[i] ^ 1;
            else
                ans[i] = flag[i];

        }
        return ans;
    }

    private int[] getOp3(int[] flag) {
        int[] ans = new int[flag.length];
        for (int i = 0; i < flag.length; i++) {
            if (i % 2 == 0)
                ans[i] = flag[i] ^ 1;
            else
                ans[i] = flag[i];

        }
        return ans;
    }

    private int[] getOp2(int[] flag) {
        int[] ans = new int[flag.length];
        for (int i = 0; i < flag.length; i++) {
            if (i % 2 != 0)
                ans[i] = flag[i] ^ 1;
            else
                ans[i] = flag[i];
        }
        return ans;
    }

    private int[] getOp1(int[] flag) {
        int[] ans = new int[flag.length];
        for (int i = 0; i < flag.length; i++) {
            ans[i] = flag[i] ^ 1;
        }
        return ans;
    }
}