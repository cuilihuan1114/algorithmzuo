/**
 * @author cuilihuan
 * @data 2020/11/28 19:08
 */
public class Problem_0415_字符串相加 {
    public static void main(String[] args) {
        System.out.println(new Problem_0415_字符串相加().addStrings("23", "87"));
    }
    public String addStrings(String num1, String num2) {
        StringBuffer sum = new StringBuffer();
        int indexNum1 = num1.length() - 1;
        int indexNum2 = num2.length() - 1;
        int add = 0;
        while (indexNum1 >= 0 || indexNum2 >= 0) {
            int ints1 = indexNum1 >= 0 ? (num1.charAt(indexNum1--) - '0') : 0;
            int ints2 = indexNum2 >= 0 ? (num2.charAt(indexNum2--) - '0') : 0;
            sum.append((ints1 + ints2 + add) % 10);
            add = (ints1+ints2+add) / 10;
        }
        if(add!=0)
            sum.append(add);
        return sum.reverse().toString();
    }
}
