/**
 * @author cuilihuan
 * @data 2020/11/19 10:08
 */
public class Problem_0005_最长回文子串 {
    //时间复杂度为O(N)
    public String longestPalindrome(String s) {
        char[] chars = manacherString(s);

        //每个i的半径
        int[] pArr = new int[chars.length];
        //圆点坐标
        int C = -1;
        //最右半径
        int R = -1;

        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < chars.length; i++) {
             //注意这里是>= 因为
            pArr[i] = i >= R ? 1 : Math.min(pArr[2 * C - i], R - i);
            while (i + pArr[i] < chars.length && i - pArr[i] > -1) {
                if (chars[i + pArr[i]] == chars[i - pArr[i]]) {
                    pArr[i]++;
                }else
                    break;
            }
            if(i+pArr[i]>R){
                C = i;
                R = i + pArr[i];
            }

            if(max < pArr[i]){
                max = pArr[i];
                index = i;
            }

        }

        //12321 -》#1#2#3#2#1#  -》pArr[i] = 3#2#1# = 6  max= 6-1
//        return s.substring(0,max-1);
        return toResult(index, max - 1,chars);
    }

    private String toResult(int index, int len,char[] s) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = index - len; i < index+len; i++) {
            if(s[i] == '#')
                continue;
            stringBuffer.append(s[i]);
        }
        return stringBuffer.toString();
    }

    private char[] manacherString(String s) {
        char[] chars = new char[s.length() * 2 + 1];
        int index  = 0;
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (i & 1) == 0 ? '#' : s.charAt(index++);
        }
        return chars;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_0005_最长回文子串().longestPalindrome("cbbd"));
    }

}
