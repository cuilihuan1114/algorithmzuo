import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by CUI on 2021/1/6
 */
public class Problem_0207_课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, List<Integer>> list = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, 0);
            list.put(i, new LinkedList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];
            map.put(cur, map.get(cur) + 1);
            list.get(pre).add(cur);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(map.get(i) == 0)
                queue.addLast(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int cur = queue.pop();
            List<Integer> curList = list.get(cur);
            for (int i = 0; i < curList.size(); i++) {
                Integer remain = map.get(curList.get(i));
                if (remain - 1 == 0) {
                    queue.addLast(curList.get(i));
                }
                map.put(curList.get(i), remain - 1);
            }
        }
        return count == numCourses;
    }
}
