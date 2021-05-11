
import java.util.*;

/**
 * @author cuilihuan
 * @data 2021/5/11 10:01
 */
public class Problem_0833_字符串中的查找与替换 {


    public static void main(String[] args) {
        System.out.println(new Problem_0833_字符串中的查找与替换().findReplaceString("abcd",
                new int[]{0, 2},
                new String[]{"a", "cd"},
                new String[]{"eee", "ffff"}));
    }

    class Info{
        int index;
        String source;
        String target;

        public Info(int index, String source, String target) {
            this.index = index;
            this.source = source;
            this.target = target;
        }
    }

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        List<Info> list = new ArrayList<>();
        for (int i = 0; i < indexes.length; i++) {
            list.add(new Info(indexes[i], sources[i], targets[i]));
        }

        Collections.sort(list, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.index - o2.index;
            }
        });

        StringBuffer sb = new StringBuffer();
        int j = 0,i=0;
        for (; i < S.length() && j < list.size(); i++) {
            Info info = list.get(j);
            if(i < info.index)
                sb.append(S.charAt(i));
            else if(i == info.index){
                int cur = i;
                int start = 0;
                while (cur < S.length() && start < info.source.length() && S.charAt(cur) == info.source.charAt(start)){
                    cur++;
                    start++;
                }
                if(start == info.source.length()){
                    sb.append(info.target);
                    i = cur - 1;
                }else
                    i = i - 1;
                j++;
            }
        }

        for (; i < S.length(); i++) {
            sb.append(S.charAt(i));
        }

        return sb.toString();
    }
}
