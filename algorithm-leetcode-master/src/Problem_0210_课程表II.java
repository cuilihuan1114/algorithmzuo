import java.util.*;

/**
 * Created by CUI on 2021/1/7
 */
public class Problem_0210_课程表II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, List<Integer>> nodes = new HashMap<>();
        HashMap<Integer, Integer> remain = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            nodes.put(i, new ArrayList<>());
            remain.put(i, 0);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];
            nodes.get(pre).add(cur);
            remain.put(cur, remain.get(cur) + 1);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (remain.get(i) == 0) {
                queue.addLast(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            Integer pos = queue.pop();
            if(set.contains(pos))
                continue;
            ans[index++] = pos;
            set.add(pos);
            for (int i = 0; i < nodes.get(pos).size(); i++) {
                int du = remain.get(nodes.get(pos).get(i)) - 1;
                if ( du == 0) {
                    queue.addLast(nodes.get(pos).get(i));
                }
                remain.put(nodes.get(pos).get(i), du);
            }
        }
        return index == numCourses  ? ans : new int[0];
    }
}
