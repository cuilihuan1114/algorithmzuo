/**
 * @author cuilihuan
 * @data 2020/12/3 20:38
 */
public class Problem_0069_x的平方根 {
    //踩的坑如下
    //第一要用二分查找 在这里需要注意两点 第一点是while(left<=right)中的等号 要有 第二点是mid*mid<=x要把left放在第一个大于x的位置 包括等于
    //第二个要注意的是如果直接用mid*mid的话会导致int类型的溢出 所以在这里需要将int类型的变成long类型 防止溢出
    public int mySqrt(int x) {
        if (x == 1)
            return 1;
        int left = 0;
        int right = x / 2;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if ((long) mid * mid <= x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}
