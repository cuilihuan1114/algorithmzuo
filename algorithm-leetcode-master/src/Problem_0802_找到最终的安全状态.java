
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/5/8 10:27
 */
public class Problem_0802_找到最终的安全状态 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        if (graph == null || graph.length == 0)
            return list;
        boolean[] flag = new boolean[graph.length];

        HashSet<Integer> all = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            if (!all.contains(i)) {
                HashSet<Integer> cur = new HashSet<>();
                if (process(graph, i, cur, all, flag))
                    flag[i] = true;
            }
        }


        for (int i = 0; i < flag.length; i++) {
            if (flag[i])
                list.add(i);
        }
        return list;

    }

    private boolean process(int[][] graph, int index, HashSet<Integer> cur, HashSet<Integer> all, boolean[] flag) {
        boolean curFlag = true;
        if (cur.contains(index)) {
            all.add(index);
            return false;
        }

        if(flag[index])
            return true;

        if(all.contains(index))
            return false;

        cur.add(index);
        for (int i = 0; i < graph[index].length; i++) {
            if (!process(graph, graph[index][i], cur, all, flag)) {
                curFlag = false;
                break;
            }
        }
        cur.remove(index);

        all.add(index);
        if (curFlag) {
            flag[index] = true;
        }
        return curFlag;
    }
}
