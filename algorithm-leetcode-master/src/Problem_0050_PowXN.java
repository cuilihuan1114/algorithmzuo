/**
 * @author cuilihuan
 * @data 2020/12/2 18:44
 */
public class Problem_0050_PowXN {
    public static void main(String[] args) {
        System.out.println(new Problem_0050_PowXN().myPow(2, -2));
    }

    /**
     * 总体的思路就是将x^7=x^4*x^2*x^1 同时将负的n次方转化成正数 因为负数的最小值比最大值多一个 所以在这里需要额外的判断一下 是不是最小的负数
     * 如果是最小的负数 则返回的是0 当然在这里1和-1除外啦
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if ((x == 1 || x == -1) && n == Integer.MIN_VALUE)
            return 1;

        if (n == Integer.MIN_VALUE)
            return 0;
        double sum = 1;
        double multip = x;
        boolean fu = false;
        if (n < 0) {
            n = -n;
            fu = true;
        }
        while (n > 0) {
            sum *= ((n & 1) == 1 ? multip : 1);
            n = n >> 1;
            multip = multip * multip;
        }
        return fu ? 1 / sum : sum;
    }
}
