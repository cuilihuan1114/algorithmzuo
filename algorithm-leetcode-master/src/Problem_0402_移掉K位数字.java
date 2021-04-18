/**
 * @author cuilihuan
 * @data 2021/3/7 21:31
 */
public class Problem_0402_移掉K位数字 {


    public static void main(String[] args) {
        System.out.println(new Problem_0402_移掉K位数字().removeKdigits("10200"
                , 1));
    }
    public String removeKdigits(String num, int k) {
        int N = num.length();
        if (k >= N)
            return "0";
        StringBuilder res = new StringBuilder();
        int j = 0;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            if (res.length() == 0 && num.charAt(i) == '0')
                continue;
            if(i + k >= N)
                break;

            j = 1;
            flag = false;
            while (i + j < N && j <= k) {
                if (num.charAt(i + j) >= num.charAt(i)) {
                    j++;
                } else {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                k--;
            } else
                res.append(num.charAt(i));
        }

        return res.length() != 0 ? res.toString() : "0";
    }
}
