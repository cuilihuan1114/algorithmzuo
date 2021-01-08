/**
 * Created by CUI on 2021/1/6
 */
public class Problem_0204_计数质数 {
    public int countPrimes(int n) {
        int count = 0;
        boolean flag = false;
        for (int i = 1; i  < n; i++) {
            flag = false;
            for (int j = 1; j * j < i ; j++) {
                if(i / j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count++;
            }
        }
        return count;
    }
}
