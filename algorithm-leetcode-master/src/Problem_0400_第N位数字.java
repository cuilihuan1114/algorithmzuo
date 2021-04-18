/**
 * @author cuilihuan
 * @data 2021/3/9 17:17
 */
public class Problem_0400_第N位数字 {

    public static void main(String[] args) {
        System.out.println(new Problem_0400_第N位数字().findNthDigit(1000000000));
    }

    public int findNthDigit(int n) {
        int index = 1;
        int start = 1;
        int end = 9;
        long curSum = 0;
        while (true) {
            curSum = (end - start + 1) * index;
            if(curSum < 0)
                break;
            if (n > curSum) {
                n = n - (int)curSum;
            } else {
                break;
            }
            start = start * 10;
            end = end * 10 + 9;
            index++;
        }

        int i = start;
        for (i = start; i <= end; i++) {
            if (n - index > 0) {
                n = n - index;
            } else
                break;
        }

        StringBuilder sb = new StringBuilder(i + "");
        for (int j = 0; j < sb.length(); j++) {
            n--;
            if (n == 0) {
                return sb.charAt(j) - '0';
            }

        }

        return 0;

    }
}
