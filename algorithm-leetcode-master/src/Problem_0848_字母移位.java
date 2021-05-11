
/**
 * @author cuilihuan
 * @data 2021/5/11 14:35
 */
public class Problem_0848_字母移位 {
    public String shiftingLetters(String S, int[] shifts) {
        char[] chars = S.toCharArray();
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] += shifts[i+1] % 26;
        }
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ((chars[i] - 'a' + shifts[i]) % 26 + 'a');
        }
        return String.valueOf(chars);
    }
}
