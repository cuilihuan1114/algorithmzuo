/**
 * @author cuilihuan
 * @data 2020/11/20 9:42
 */
public class Problem_0008_字符串转换整数 {
    public static void main(String[] args) {
        System.out.println(new Problem_0008_字符串转换整数().myAtoi("2147483648"));
        System.out.println(Integer.MAX_VALUE);
    }

    public int myAtoi(String s) {
        //去空格
        s = s.trim();
        s = removeHeadZero(s);

        if(isValid(s))
            return 0;

        int max = Integer.MIN_VALUE / 10;
        int maxCur = Integer.MIN_VALUE % 10;

        boolean flag = s.charAt(0) == '-';
        int sum = 0;
        int cur = 0;
        for (int i = (s.charAt(0) == '-' || s.charAt(0) == '+') ? 1 : 0; i < s.length(); i++) {
            cur = '0' - s.charAt(i);
            if (sum < max || (sum == max && cur < maxCur))
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            sum = sum * 10 + cur;
        }
        //在这里需要注意一下的是 如果是正数的话最大范围是2147483647 而负数的最大范围是-2147483648
        //所以在进行正数转化成负数的时候会把2147483648转化成-2147483648 而在正数当中2147483648是无效的超过了最大值
        //而在负数当中2147483648是有效的 依然可以进行转化 所在最后还是要判断一下 sum如果等于-2147483648并且还是正数 则要返回最大值
        return flag ? sum : (sum == Integer.MIN_VALUE)?Integer.MAX_VALUE:-sum;
    }

    private boolean isValid(String s) {
        if (s == null || s.equals(""))
            return true;
        //不能忘了这种判断
        if((s.charAt(0) == '+' || s.charAt(0) == '-')&&s.length() == 1)
            return true;
        return false;
    }

    private String removeHeadZero(String s) {
        if (s == null || s.equals(""))
            return "";
        char first = s.charAt(0);
        if (first != '+' && first != '-' && (first < '0' || first > '9'))
            return "";
        StringBuffer sum = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0 && (s.charAt(i) < '0' || s.charAt(i) > '9'))
                break;
            sum.append(s.charAt(i));
        }
        return sum.toString();
    }
}
