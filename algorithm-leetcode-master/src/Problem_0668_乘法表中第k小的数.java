/**
 * @author cuilihuan
 * @data 2021/3/29 19:21
 */
public class Problem_0668_乘法表中第k小的数 {

    public static void main(String[] args) {
        System.out.println(new Problem_0668_乘法表中第k小的数().findKthNumber(3, 3, 5));
    }

    int check(int m, int n, int mid)  //统计一共有多少个数比mid值小
    {
        int res = 0;
        for (int i = 1; i <= m; i++) {
            res += Math.min(n, mid / i);  //一行的所有数的个数和mid/n个数，二者中取最小值
        }
        return res;
    }

    int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int nums = check(m, n, mid);
            if (nums >= k) r = mid - 1;
            else l = mid + 1;
        }
        return r + 1;
    }

}