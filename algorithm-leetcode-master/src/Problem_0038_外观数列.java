/**
 * @author cuilihuan
 * @data 2020/11/24 10:44
 */
public class Problem_0038_外观数列 {
    public static void main(String[] args) {
        System.out.println(new Problem_0038_外观数列().countAndSay(5));
    }

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String pre = countAndSay(n - 1);
        StringBuffer buffer = new StringBuffer();
        int count = 1;
        for (int i = 0; i < pre.length(); i++) {
            if (i + 1 < pre.length() && pre.charAt(i) == pre.charAt(i + 1)) {
                count++;
            } else {
                buffer.append(count).append(pre.charAt(i));
                count = 1;
            }
        }
        if (count != 1)
            buffer.append(count).append(pre.charAt(pre.length() - 1));
        return buffer.toString();
    }
}
