
import java.nio.CharBuffer;
import java.util.*;

/**
 * @author cuilihuan
 * @data 2021/4/14 10:49
 */
public class Problem_0756_金字塔转换矩阵 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("BCG");
        list.add("CDE");
        list.add("GEA");
        list.add("FFF");
        System.out.println(new Problem_0756_金字塔转换矩阵().pyramidTransition("BCD", list));
    }


    public boolean pyramidTransition(String bottom, List<String> allowed) {
        HashMap<String, List<Character>> map = new HashMap<>();
        for (int i = 0; i < allowed.size(); i++) {
            String cur = allowed.get(i);
            String s = cur.substring(0, 2);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(cur.charAt(cur.length() - 1));
        }

        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < bottom.length(); i++) {
            list.add(bottom.charAt(i));
        }

        LinkedList<Character> cur = new LinkedList<>();
        return dfs(list, cur, map, 0);
    }

    private boolean dfs(LinkedList<Character> pre, LinkedList<Character> cur, HashMap<String, List<Character>> map, int index) {
        if (index == pre.size()-1) {
            if(cur.size() == 1)
                return true;
            else
                return dfs(cur, new LinkedList<>(), map, 0);
        }

        String ans = pre.get(index) +""+ pre.get(index + 1) ;
        if(!map.containsKey(ans)){
            return false;
        }else {
            List<Character> list = map.get(ans);
            for (int i = 0; i < list.size(); i++) {
                cur.addLast(list.get(i));
                if(dfs(pre,cur,map,index+1))
                    return true;
                cur.removeLast();
            }
        }

        return false;
    }
}
