/**
 * Created by CUI on 2021/1/6
 */
public class Problem_0171_Excel表列序号 {
    public int titleToNumber(String s) {
       if(s == null || s.length() == 0)
           return 0;
        char[] array = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum * 26 + array[i] - 'A' + 1;
        }
        return sum;
    }
}
