/**
 * @author cuilihuan
 * @data 2020/12/3 19:34
 */
public class Problem_0058_最后一个单词的长度 {

    public static void main(String[] args) {
        System.out.println(new Problem_0058_最后一个单词的长度().lengthOfLastWord("a b   "));
    }
    //垃圾题 题目也没描述不清
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int len = 0;
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            pre = len == 0 ? pre : len;
            len = s.charAt(i) == ' ' ? 0 : len + 1;
        }
        return len == 0 ? pre : len ;
    }
}
