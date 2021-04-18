/**
 * @author cuilihuan
 * @data 2021/4/8 14:46
 */
public class Problem_0680_验证回文字符串Ⅱ {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        char[] array = s.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] == array[right]) {
                left++;
                right--;
            } else {
                break;
            }
        }
        if (left >= right)
            return true;

        boolean flag = isPara(array, left + 1, right);
        if (flag)
            return true;
        flag = isPara(array, left, right - 1);
        return flag;
    }

    private boolean isPara(char[] array, int left, int right) {
        while (left < right) {
            if (array[left] == array[right]) {
                left++;
                right--;
            } else {
                break;
            }
        }
        if (left >= right)
            return true;
        return false;
    }
}