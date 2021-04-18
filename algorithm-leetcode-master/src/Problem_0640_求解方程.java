/**
 * @author cuilihuan
 * @data 2021/3/23 10:23
 */
public class Problem_0640_求解方程 {
    public static void main(String[] args) {
        System.out.println(new Problem_0640_求解方程().solveEquation("x+5-3+x=6+x-2"));
    }

    public String solveEquation(String equation) {
        if (equation == null || equation.length() == 0)
            return "Infinite solutions";

        if (!equation.contains("="))
            return "Infinite solutions";

        String[] split = equation.split("=");

        int[] left = getNums(split[0]);
        int[] right = getNums(split[1]);

        int x = left[0] - right[0];
        int num = right[1] - left[1];
        if (x == 0) {
            if (num == 0)
                return "Infinite solutions";
            return "No solution";

        } else {
            return "x=" + (num / x);
        }
    }

    private int[] getNums(String s) {
        int sumDigit = 0;
        int sumX = 0;
        int curSum = 0;
        boolean flagOp = true;
        boolean flagSpe = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (flagSpe) {
                    sumX = sumX + (flagOp ? 1 : -1) * curSum;
                } else {
                    sumDigit = sumDigit + (flagOp ? 1 : -1) * curSum;
                }
                curSum = 0;
                flagOp = s.charAt(i) == '+';
                flagSpe = false;
            } else if (s.charAt(i) == 'x') {

                if (!(i - 1 >= 0 && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9'))
                    curSum = 1;
                flagSpe = true;
            } else {
                curSum = curSum * 10 + (s.charAt(i) - '0');
            }
        }
        if (flagSpe) {
            sumX = sumX + (flagOp ? 1 : -1) * curSum;
        } else {
            sumDigit = sumDigit + (flagOp ? 1 : -1) * curSum;
        }
        return new int[]{sumX, sumDigit};
    }
}