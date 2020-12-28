/**
 * @author cuilihuan
 * @data 2020/11/28 18:39
 */
public class Problem_0043_字符串相乘 {
    public static void main(String[] args) {
        System.out.println(new Problem_0043_字符串相乘().multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.equals("0") || num2.equals("0"))
            return "0";

        int N = num1.length() - 1;
        int M = num2.length() - 1;
        StringBuffer sum = new StringBuffer();
        int zeroNum = 0;
        for (int i = M; i >= 0; i--) {
            StringBuffer cur = new StringBuffer();
            for (int j = 0; j < zeroNum; j++) {
                cur.append("0");
            }
            zeroNum++;
            int one = num2.charAt(i) - '0';
            int add = 0;
            for (int j = N; j >= 0; j--) {
                int other = num1.charAt(j) - '0';
                cur.append((one * other + add) % 10);
                add = (one * other + add) / 10;
            }
            if (add != 0) {
                cur.append(add);
            }

            sum = toAddString(sum, cur.reverse());

        }
        return sum.toString();
    }

    private StringBuffer toAddString(StringBuffer sum, StringBuffer cur) {
        StringBuffer add = new StringBuffer();
        int x = sum.length() - 1;
        int y = cur.length() - 1;

        int yu = 0;
        while (x >= 0 || y >= 0) {
            int a = x >= 0 ? (sum.charAt(x) - '0') : 0;
            int b = y >= 0 ? (cur.charAt(y) - '0') : 0;
            add.append((a + b + yu) % 10);
            yu = (a + b + yu) / 10;
            x--;
            y--;
        }
        if (yu != 0)
            add.append(yu);
        return add.reverse();
    }

}
