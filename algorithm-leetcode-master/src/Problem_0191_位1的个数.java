/**
 * Created by CUI on 2021/1/6
 */
public class Problem_0191_位1的个数 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n - (n & (~n + 1));
        }
        return count;
    }
}
