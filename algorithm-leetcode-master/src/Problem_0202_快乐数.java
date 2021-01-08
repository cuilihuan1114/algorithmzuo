import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by CUI on 2021/1/6
 */
public class Problem_0202_快乐数 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        int remain = 0;
        while (n != 1) {
            int sum = 0;
            while (n!=0){
                remain = n % 10;
                sum += remain * remain;
                n = n / 10;
            }
            n = sum;
            if(set.contains(n))
                return false;
            else
                set.add(n);
        }
        return true;
    }
}
