/**
 * @author cuilihuan
 * @data 2020/11/21 14:57
 */
public class Problem_0012_整数转罗马数字 {
    public static void main(String[] args) {
        System.out.println(new Problem_0012_整数转罗马数字().intToRoman(27));
    }

    public String intToRoman(int num) {
        String[][] c = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}};
        StringBuffer buffer = new StringBuffer();
        buffer.append(c[3][num / 1000]).append(c[2][num / 100 % 10]).append(c[1][num / 10 % 10]).append(c[0][num % 10]);
        return buffer.toString();
    }

    public String intToRoman1(int num) {
        int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String reps[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String res = "";
        for (int i = 0; i < 13; i++) {
            while (num >= values[i]) {
                num -= values[i];
                res += reps[i];
            }
        }
        return res;
    }
}
