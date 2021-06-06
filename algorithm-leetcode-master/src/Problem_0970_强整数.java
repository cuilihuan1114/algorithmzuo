
import java.util.*;

/**
 * @author cuilihuan
 * @data 2021/5/30 11:11
 */
public class Problem_0970_强整数 {
    public static void main(String[] args) {
        System.out.println(new Problem_0970_强整数().powerfulIntegers(2, 2, 40000));
        System.out.println(new Problem_0970_强整数().powerfulIntegers1(2, 2, 40000).size());
    }

    public List<Integer> powerfulIntegers1(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();

        for (int a = 1; a < bound; a *= x) {
            for (int b = 1; a + b <= bound; b *= y) {
                set.add(a + b);
                if (y == 1) break;
            }
            if (x == 1) break;
        }

        return new ArrayList<>(set);
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        process(1, 1, set, x, y, bound);
        List<Integer> list = new ArrayList<>();
        list.addAll(set);
        System.out.println(list.size());
        return list;
    }

    private void process(int xPre, int yPre, Set<Integer> set, int x, int y, int bound) {

        int result = xPre + yPre;
        if (result <= bound) {
            set.add(result);
            if (xPre != xPre * x)
                process(xPre * x, yPre, set, x, y, bound);
            if (yPre != yPre * y)
                process(xPre, yPre * y, set, x, y, bound);
        }


    }
}
