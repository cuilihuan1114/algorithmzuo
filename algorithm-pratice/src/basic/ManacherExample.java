package basic;

/**
 * @author cuilihuan
 * @data 2020/11/19 10:54
 */
public class ManacherExample {
    public static void main(String[] args) {
        System.out.println(shortestEnd("abcd123321"));
    }

    public static String shortestEnd(String str) {
        char[] s = manacherChars(str);
        System.out.println(s);
        int least = s.length - 1;

        int[] pArr = new int[s.length];
        int C = -1;
        int R = -1;

        int max = 0;

        for (int i = 0; i < s.length; i++) {
            pArr[i] = i >= R ? 1 : Math.min(pArr[2 * C - i], R - i);
            while (i + pArr[i] < s.length && i - pArr[i] > -1) {
                if (s[i + pArr[i]] == s[i - pArr[i]]) {
                    pArr[i]++;
                } else
                    break;
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }

            if ( i + pArr[i] - 1 == least) {
//            if (R == s.length) {
                max = pArr[i];
                break;
            }
        }
        char[] chars = new char[str.length() - max+1];
        for (int i = 0; i < chars.length; i++) {
            chars[chars.length - i - 1] = str.charAt(i);
        }
        return String.valueOf(chars);
    }

    private static char[] manacherChars(String str) {
        char[] chars = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (i & 1) == 0 ? '#' : str.charAt(index++);
        }
        return chars;
    }
}
