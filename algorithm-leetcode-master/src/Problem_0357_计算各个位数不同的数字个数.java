/**
 * @author cuilihuan
 * @data 2021/3/4 19:30
 */
public class Problem_0357_计算各个位数不同的数字个数 {

    public static void main(String[] args) {
        System.out.println(new Problem_0357_计算各个位数不同的数字个数().countNumbersWithUniqueDigits(3));
    }

    public int countNumbersWithUniqueDigits(int n) {
        n = Math.min(n, 10);
        if(n == 0) return 1;
        if(n == 1) return 10;
        int sum = 10;
        for (int i = 2; i <= n; i++) {
            boolean[] use = new boolean[10];
            sum += process(use, i,0);
        }
        return sum;
    }

    private int process(boolean[] use, int n, int index) {
        if(index == n)
            return 1;

        int cur = 0;
        if(index != 0 && !use[0]){
            use[0] = true;
            cur += process(use, n, index + 1);
            use[0] = false;
        }

        for (int i = 1; i <= 9 ; i++) {
            if(!use[i]){
                use[i] = true;
                cur += process(use, n, index + 1);
                use[i] = false;
            }
        }
        return cur;
    }
}
