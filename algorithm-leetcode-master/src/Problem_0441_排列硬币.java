/**
 * @author cuilihuan
 * @data 2021/3/12 20:31
 */
public class Problem_0441_排列硬币 {

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {

            System.out.println(i + "==" + new Problem_0441_排列硬币().arrangeCoins(i));
        }
    }

    public int arrangeCoins(int n) {
        int row = 0;
        int cur = n;
        int i = 1;
        for (i = 1; i <= n; i++) {
            if (n - i >= 0)
                n = n - i;
            else
                break;
        }

        return i - 1;
    }


}
