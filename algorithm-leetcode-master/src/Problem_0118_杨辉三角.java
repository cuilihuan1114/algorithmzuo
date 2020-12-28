import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2020/12/20 16:13
 */
public class Problem_0118_杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> preList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> curList = new ArrayList<>();
            curList.add(1);
            for (int j = 1; j < preList.size() - 1; j++) {
                curList.add(preList.get(j) + preList.get(j + 1));
            }
            curList.add(1);
            preList = curList;
            list.add(curList);
        }
        return list;

    }
}
