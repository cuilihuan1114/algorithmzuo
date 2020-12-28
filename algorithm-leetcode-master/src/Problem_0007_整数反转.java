/**
 * @author cuilihuan
 * @data 2020/11/20 9:12
 */
public class Problem_0007_整数反转 {
    public int reverse(int x) {
        //在这里判断是否为负数 也就是最高位向右移动31位
        //好处便是负数的范围比正数的大1 第二个优点是便于统一处理 后面可以根据负数的范围来判断最大值
        boolean flag = ((x >> 31) & 1) == 1;
        x = flag ? x : -x;

        int sum = 0;
        int shang = x;
        int remainder = 0;

        int maxShang = Integer.MIN_VALUE / 10;
        int maxRemainder = Integer.MIN_VALUE % 10;

        while (shang != 0) {
            //判断是否超范围了
            if (sum < maxShang || (sum == maxShang && shang < maxRemainder))
                return 0;
            remainder = shang % 10;
            sum = sum * 10 + remainder;
            shang = shang / 10;
        }

        return flag ? sum : -sum;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_0007_整数反转().reverse(1534236469));
    }
}
