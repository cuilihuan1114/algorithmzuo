import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/3/9 15:29
 */
public class Problem_0440_字典序的第K小数字 {

    public static void main(String[] args) {
        System.out.println(new Problem_0440_字典序的第K小数字().findKthNumber(13, 5));
    }

    public int findKthNumber(int n, int k) {
        long res = 1;
        while (k > 0) {
            int num = getNode(n, res, res + 1);
            if (k > num) {
                k = k - num;
                res++;
            } else {
                k = k - 1;
                if (k != 0)
                    res = res * 10;
            }
        }
        return (int)res;
    }

    private int getNode(int n, long start, long last) {
        int num = 0;
        while (start <= n) {
            num += (Math.min(last, n + 1) - start);
            start = start * 10;
            last = last * 10;
        }
        return num;
    }

    public int findKthNumber1(int n, int k) {
        int index = 0;
        int[] res = new int[1];
        int[] remain = new int[1];
        List<Integer> list = new ArrayList<>();
        remain[0] = k;
        process(n, index, res, remain, 0, list);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i)+" ");
//        }
        return res[0];
    }

    private boolean process(int n, int index, int[] res, int[] remain, int cur, List<Integer> list) {


        int next = 0;

        if (index != 0) {
            next = cur * 10;
            if (next > n)
                return false;
            remain[0] = remain[0] - 1;
            list.add(next);
            if (process(n, index + 1, res, remain, next, list))
                return true;
        }

        if (remain[0] == 0) {
            res[0] = next;
            return true;
        }

        for (int i = 1; i <= 9; i++) {
            next = cur * 10 + i;
            if (next > n) {
                return false;
            }
            list.add(next);
            remain[0] = remain[0] - 1;
            if (remain[0] == 0) {
                res[0] = next;
                return true;
            }

            if (process(n, index + 1, res, remain, next, list)) {
                return true;
            }

        }
        return false;

    }
}
