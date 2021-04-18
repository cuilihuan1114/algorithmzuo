import java.util.HashSet;
import java.util.Set;

/**
 * @author cuilihuan
 * @data 2021/4/13 14:20
 */
public class Problem_0788_旋转数字 {

    public static void main(String[] args) {
        System.out.println(new Problem_0788_旋转数字().rotatedDigits(3));
    }


    public int rotatedDigits(int N) {
        Set<Integer> same = new HashSet<>();
        same.add(0);
        same.add(1);
        same.add(8);

        Set<Integer> notSame = new HashSet<>();
        notSame.add(2);
        notSame.add(5);
        notSame.add(6);
        notSame.add(9);

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isGoodNum(i, same, notSame))
                count++;
        }
        return count;
    }

    private boolean isGoodNum(int num, Set<Integer> same, Set<Integer> notSame) {
        boolean flag = false;
        while (num != 0) {
            int res = num % 10;
            num = num / 10;
            if (same.contains(res)) {
                continue;
            } else if (notSame.contains(res)) {
                flag = true;
            } else
                return false;
        }
        return flag;
    }
}