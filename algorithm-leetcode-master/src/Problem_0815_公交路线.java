
import java.util.*;

/**
 * @author cuilihuan
 * @data 2021/5/8 19:53
 */
public class Problem_0815_公交路线 {

    public static void main(String[] args) {
        System.out.println(new Problem_0815_公交路线().numBusesToDestination(new int[][]{{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}}, 15, 12));
    }


    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target)
            return 0;
        Map<Integer, List<Integer>> map = new HashMap();
        boolean flag = false;
        boolean flag1 = false;
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int num = routes[i][j];
                if(num == target)
                    flag = true;
                if(num == source)
                    flag1 = true;
                if (!map.containsKey(num))
                    map.put(num, new ArrayList<>());
                List<Integer> list = map.get(num);
                list.add(i);
            }
        }

        if(!flag || !flag1)
            return -1;

        Set<Integer> all = new HashSet<>();
        Set<Integer> ans = new HashSet<>();

        List<Integer> firstList = map.get(source);
        int count = 1;

        for (int i = 0; i < firstList.size(); i++) {
            for (int j = 0; j < routes[firstList.get(i)].length; j++) {
                if(routes[firstList.get(i)][j] == target)
                    return count;
                if(source != routes[firstList.get(i)][j]) {
                    all.add(routes[firstList.get(i)][j]);
                    ans.add(routes[firstList.get(i)][j]);
                }
            }
        }

        while (!ans.isEmpty()) {
            Set<Integer> cur = new HashSet<>();
            count++;
            for (Integer key : ans) {
                List<Integer> list = map.get(key);
                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < routes[list.get(i)].length; j++) {
                        if(routes[list.get(i)][j] == target)
                            return count;
                        if (!all.contains(routes[list.get(i)][j])) {
                            cur.add(routes[list.get(i)][j]);
                            all.add(routes[list.get(i)][j]);
                        }
                    }

                }
            }
            ans = cur;
        }
        return -1;

    }
}
