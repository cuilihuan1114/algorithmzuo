/**
 * @author cuilihuan
 * @data 2021/3/20 9:35
 */
public class Problem_0504_七进制数 {

    public static void main(String[] args) {
        System.out.println(new Problem_0504_七进制数().convertToBase7(-7));
    }

    public String convertToBase7(int num) {
        if (num == 0)
            return "0";

        boolean flag = false;
        flag = num > 0;
        num = Math.abs(num);
        StringBuffer sb = new StringBuffer();
        int res = 0;
        while (num != 0) {
            res = num % 7;
            sb.append(res);
            num = num / 7;
        }
        return !flag ? ("-") + sb.reverse().toString() : sb.reverse().toString();
    }
}