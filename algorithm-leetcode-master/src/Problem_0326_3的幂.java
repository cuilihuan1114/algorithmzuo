/**
 * Created by CUI on 2021/1/12
 */
public class Problem_0326_3的幂 {
    public boolean isPowerOfThree(int n) {
        if (n == 0)
            return false;
        while (n != 1) {
            if (n % 3 == 0)
                n = n / 3;
            else
                return false;
        }
        return true;
    }
}
