/**
 * @author cuilihuan
 * @data 2021/3/21 19:17
 */
public class Problem_0633_平方数之和 {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            long remain = c - a * a;
            if (isExist(remain))
                return true;
        }
        return false;
    }

    private boolean isExist(long remain) {
        long left = 0;
        long right = remain;
        while (left <= right) {
            long middle = left + (right - left) / 2;
            if (middle * middle == remain)
                return true;
            else if (middle * middle < remain) {
                left = middle + 1;
            } else
                right = middle - 1;
        }
        return false;
    }

}