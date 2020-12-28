import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2020/12/20 16:22
 */
public class Problem_0119_杨辉三角II {
    public List<Integer> getRow(int rowIndex) {
        rowIndex = rowIndex + 1;
        List<Integer> preList = new ArrayList<>();
        if (rowIndex == 0)
            return preList;
        preList.add(1);
        List<Integer> curList = preList;
        for (int i = 1; i < rowIndex; i++) {
            curList = new ArrayList<>();
            curList.add(1);
            for (int j = 0; j < preList.size() - 1; j++) {
                curList.add(preList.get(j) + preList.get(j + 1));
            }
            curList.add(1);
            preList = curList;
        }
        return curList;
    }
}
