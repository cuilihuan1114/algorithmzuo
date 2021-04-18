/**
 * @author cuilihuan
 * @data 2021/3/5 14:11
 */
public class Problem_0397_整数替换 {

    public static void main(String[] args) {
//        for (int i = 1; i <= 10000; i++) {
            System.out.println(65535 + "=" + new Problem_0397_整数替换().integerReplacement(65535));
//        }
    }


    public int integerReplacement(int n) {
        int count = 0;
        while (n!=1){
            //与运算判断最后一位来区分奇偶
            if((n & 1) == 0){
                //偶数直接无符号右移，
                //2147483647 会被奇数处理算法加一溢出为负数，
                //若选用带符号右移将无法回到1.
                n >>>=1;
                count++;
            }
            else {
                //识别奇数的上一位是否为1，即 以 10 结尾(xxxx01)还是以11结尾(xxxx11)
                if((n & 2) == 0){
                    //01结尾最优则应当 用 n -1 取代 n
                    n -= 1;
                    count++;
                }else {
                    //11结尾除3这个特殊情况外，其余选用 n + 1取代 n，原因如上
                    if(n == 3){
                        //3的特殊性处理，原因如上
                        count+=2;break;
                    }else {
                        n += 1;
                    }
                    count++;
                }
            }
        }
        return count;
    }


    public int integerReplacement1(int n) {
        if (n == 0) return 1;
        return process(n);
    }

    private int process(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 0;

        int res = 0;
        if ((n - 1) % 2 == 0)
            res = process((n - 1) / 2) + 2;
        else if (n % 2 == 0) {
            res =  process(n / 2) + 1;
        } else
            res = process((n + 1) / 2) + 2;
        return res;
    }
}
