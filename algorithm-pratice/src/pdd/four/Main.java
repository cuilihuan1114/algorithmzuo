package pdd.four;

/**
 * @author cuilihuan
 * @data 2021/4/9 14:59
 */
public class Main {
    public static void main(String[] args) {
        int sum = 0;
        int N = 100;
        int K = 18;

        for (int i = 1; i <= N; i++) {
            sum += get(i, K);
        }
        System.out.println(sum);
    }

    private static int get(int i, int k) {
        if(i == 1 || i % k != 0)
            return 0;
        return 1 + get(i / k ,k);
    }
}
