


import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author cuilihuan
 * @data 2021/5/11 21:33
 */
public class Problem_0854_相似度为K的字符串 {


    public static void main(String[] args) {
        System.out.println(new Problem_0854_相似度为K的字符串().kSimilarity("abac", "baca"));
    }


    class Info{
        String s;
        int pos;

        public Info(String s, int pos) {
            this.s = s;
            this.pos = pos;
        }
    }

    public int kSimilarity(String s1, String s2) {
        if(s1 == null || s1.length() == 0)
            return 0;

        if(s1.equals(s2))
            return 0;

        HashSet<String> all = new HashSet<>();
        int count = 0;
        LinkedList<Info> list = new LinkedList<>();
        list.addLast(new Info(s1, 0));


        while (list.size() != 0){
            LinkedList<Info> ans = new LinkedList<>();
            count++;
            while (list.size() != 0){
                Info pop = list.pop();
                char[] curArray = pop.s.toCharArray();
                int start = pop.pos;
                while (start < curArray.length){
                    if(curArray[start] != s2.charAt(start))
                        break;
                    start++;
                }
                if(start == curArray.length)
                    return count;

                char tmp = curArray[start];
                for (int i = start + 1; i < curArray.length; i++) {
                    if(curArray[i] != s2.charAt(start))
                        continue;
                    curArray[start] = curArray[i];
                    curArray[i] = tmp;
                    String s = String.valueOf(curArray);
                    if(s.equals(s2))
                        return count;
                    if(!all.contains(s)) {
                        ans.addLast(new Info(s, start + 1));
                        all.add(s);
                    }
                    curArray[i] = curArray[start];
                }
                curArray[start] = tmp;
            }
            list = ans;
        }

        return 0;
    }
}
