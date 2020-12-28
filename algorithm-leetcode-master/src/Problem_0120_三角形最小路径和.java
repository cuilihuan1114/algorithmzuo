import java.util.List;

/**
 * @author cuilihuan
 * @data 2020/12/20 18:38
 */
public class Problem_0120_三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 1; i >0 ; i--) {
            for (int j = 0; j < triangle.get(i).size() - 1; j++) {
                triangle.get(i - 1).set(j, triangle.get(i - 1).get(j) + (Math.min(triangle.get(i).get(j), triangle.get(i).get(j + 1))));
            }
        }
        return triangle.get(0).get(0);
    }
}
