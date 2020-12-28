/**
 * @author cuilihuan
 * @data 2020/11/21 9:36
 */
public class Problem_0014_最长公共前缀 {

    public static void main(String[] args) {
        System.out.println(new Problem_0014_最长公共前缀().longestCommonPrefix(new String[]{""}));
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0)
            return "";

        StringBuffer buffer = new StringBuffer();
        int index = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            index = Math.min(index, strs[i].length());
        }
        int i = 0;
        char c;
        int j = -1;
        while (i < index) {
            for (j = 1, c = strs[0].charAt(i); j < strs.length; j++) {
                if (c != strs[j].charAt(i))
                    return buffer.toString();
            }
            buffer.append(c);
            i++;
        }
        return buffer.toString();
    }
}
