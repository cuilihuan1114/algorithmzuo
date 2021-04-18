/**
 * @author cuilihuan
 * @data 2021/4/13 10:54
 */
public class Problem_0754_到达终点数字 {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + "=" + new Problem_0754_到达终点数字().reachNumber(i));
        }
    }

    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0)
            target -= ++k;
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }
}