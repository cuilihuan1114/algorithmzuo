import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/4/12 20:37
 */
public class Problem_0797_所有可能的路径 {

    public static void main(String[] args) {
        System.out.println(new Problem_0797_所有可能的路径().allPathsSourceTarget(new int[][]{{2}, {}, {1}}));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if (graph == null || graph.length == 0)
            return res;

        List<Integer> list = new ArrayList<>();
        list.add(0);
        process(graph, 0, list, res);
        return res;
    }

    private void process(int[][] graph, int index, List<Integer> list, List<List<Integer>> res) {

        if (list.size() != 0 && list.get(list.size() - 1) == graph.length - 1) {
            res.add(new ArrayList<>(list));
            return;
        }


        for (int i = 0; i < graph[index].length; i++) {
            int cur = graph[index][i];
            list.add(cur);
            process(graph, cur, list, res);
            list.remove(list.size() - 1);
        }
    }
}