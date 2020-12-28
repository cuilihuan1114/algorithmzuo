/**
 * @author cuilihuan
 * @data 2020/11/21 14:25
 */
public class Problem_0009_回文数 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        for (int i = 0,j = chars.length - 1; i < chars.length; i++,j--) {
            if(i >= j)
                return true;
            if(chars[i] != chars[j])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_0009_回文数().isPalindrome(1));
    }

}
