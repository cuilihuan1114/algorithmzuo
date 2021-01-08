/**
 * Created by CUI on 2021/1/6
 */
public class Problem_0172_阶乘后的零 {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n / 5 != 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
