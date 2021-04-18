/**
 * @author cuilihuan
 * @data 2021/3/9 9:08
 */
public class Problem_0423_从英文中重建数字 {
    public String originalDigits(String s) {
        //z            w              u            x     v        g
        String[] digit = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Character[] op = new Character[]{'z', '0', 'w', '0', 'u', '0', 'x', '0', 'g', '0'};
        // one three five seven nine
        // o   h     f      s      e

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        int[] res = new int[10];
        process(digit, op, res, count);
        op = new Character[]{'0', 'o', '0', 'h', '0', 'f', '0', 's', '0', 'e'};
        process(digit, op, res, count);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i]; j++) {
                sb.append(i);
            }
        }

        return sb.toString();


    }

    public void process(String[] digit, Character[] op, int[] res, int[] count) {
        for (int i = 0; i < op.length; i++) {
            if (op[i] != '0' && count[op[i] - 'a'] != 0) {
                int num = count[op[i] - 'a'];
                count[op[i] - 'a'] = 0;
                for (int j = 0; j < digit[i].length(); j++) {
                    count[digit[i].charAt(j) - 'a'] -= num;
                }
                res[i] += num;
            }
        }
    }
}
