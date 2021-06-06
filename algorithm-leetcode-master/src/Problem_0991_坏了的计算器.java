
/**
 * @author cuilihuan
 * @data 2021/5/30 15:51
 */
public class Problem_0991_坏了的计算器 {

    public static void main(String[] args) {
        System.out.println(new Problem_0991_坏了的计算器().brokenCalc(3, 10));
    }

    public int brokenCalc(int x, int y) {
        if(y <= x)
            return x - y;

        int ans = 0;
        if(y % 2 != 0){
            ans++;
            y = y + 1;
        }

        int res = y;
        while (x < res){
            if(res % 2 != 0){
                res++;
                ans++;
                continue;
            }
            res = res / 2;
            ans++;
        }

        int p1 = ans + (x - res);
        return p1;
    }
}
