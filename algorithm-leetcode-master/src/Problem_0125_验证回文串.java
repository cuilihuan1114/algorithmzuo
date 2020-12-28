/**
 * @author cuilihuan
 * @data 2020/12/23 19:40
 */
public class Problem_0125_验证回文串 {
    public static void main(String[] args) {
        System.out.println('A' - 'a');
    }

    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)
            return true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if(isValid(s.charAt(left)) && isValid(s.charAt(right))){
                if(isCan(s.charAt(left),s.charAt(right))){
                    left++;
                    right--;
                }else
                    return false;
            }else {
                left += isValid(s.charAt(left)) ? 0 : 1;
                right += isValid(s.charAt(right)) ? 0 : -1;
            }
        }
        return true;
    }

    private boolean isCan(char left, char right) {
        if(isNumber(left) && isNumber(right) && left == right )
            return true;
        if(isLetter(left) && isLetter(right) && (left == right || Math.abs(left - right) == 32))
            return true;
        return false;
    }

    public boolean isValid(char a){
        return isLetter(a) || isNumber(a);
    }

    public boolean isLetter(char a) {
        return (a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z');
    }

    public boolean isNumber(char num){
        return num >= '0' && num <= '9';
    }
}
