package D0416;

import java.util.Scanner;

/**
 * @author cuilihuan
 * @data 2021/4/9 17:25
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        char[] array = s.toCharArray();
        System.out.println(process(array, 0).res);
    }

    static class Info {
        int next;
        String res = "";

        public Info(int next, String res) {
            this.next = next;
            this.res = res;
        }

        public Info() {
        }
    }

    private static Info process(char[] array, int index) {
        if (index == array.length)
            return new Info();

        StringBuffer sb = new StringBuffer();
        int sum = 0;
        for (int i = index; i < array.length; i++) {
            char cur = array[i];
            if (cur >= '0' && cur <= '9') {
                sum = sum * 10 + cur - '0';
            } else if ((cur >= 'A' && cur <= 'Z')) {
                sum = (sum == 0) ? 1 : sum;
                for (int j = 0; j < sum; j++) {
                    sb.append(cur);
                }
                sum = 0;
            }else if(cur == '{'){
                Info ans = process(array, i + 1);
                sum = (sum == 0) ? 1 : sum;
                for (int j = 0; j < sum; j++) {
                    sb.append(ans.res);
                }
                sum = 0;
                i = ans.next - 1;
            }else if(cur == '}'){
                return new Info(i + 1, sb.toString());
            }
        }

        if(sum != 0)
            sb.append(sum);

        return new Info(array.length,sb.toString());
    }
}
