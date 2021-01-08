/**
 * Created by CUI on 2021/1/2
 */
public class Problem_0344_反转字符串 {
    public void reverseString(char[] s) {
        if(s == null || s.length == 0)
            return;
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right++] = temp;
        }
    }
}
