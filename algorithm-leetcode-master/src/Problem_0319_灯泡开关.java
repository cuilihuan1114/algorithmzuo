/**
 * Created by CUI on 2021/3/1
 */
public class Problem_0319_灯泡开关 {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + "==" + new Problem_0319_灯泡开关().bulbSwitch1(i));
        }

    }


    public int bulbSwitch(int n) {
        for (int i = 1; i <= n + 1; i++) {
            if (i * i > n) {
                return i - 1;
            }
        }
        return 0;
    }

    public int bulbSwitch1(int n) {
        boolean[] res = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j % i == 0) {
                    res[j] = !res[j];
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (res[i])
                count++;
        }

        return count;
    }
}
