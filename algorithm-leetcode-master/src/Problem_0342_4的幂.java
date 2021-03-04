/**
 * Created by CUI on 2021/3/1
 */
public class Problem_0342_4的幂 {

    public boolean isPowerOfFour(int n) {
        if (n == 0) return false;
        while (n % 4 == 0) n /= 4;
        return n == 1;
    }

    public boolean isPowerOfFour1(int n) {
        if(n == 1)
            return true;
        int multi = 1;
        for (int i = 1; i < n; i++) {
            multi = multi * 4;
            if(multi == n)
                return true;
            else if(multi > n)
                return false;
        }

        return false;
    }
}
