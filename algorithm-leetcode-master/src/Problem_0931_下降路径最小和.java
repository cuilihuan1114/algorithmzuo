
import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/5/27 15:35
 */
public class Problem_0931_下降路径最小和 {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int ans = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix[0].length; i++) {
            int res = matrix[0][i] + process(matrix, 1, i,map);
            ans = Math.min(ans, res);
        }

        return ans;
    }

    private int process(int[][] matrix, int x, int y, Map<String, Integer> map) {

        String key = x + "_" + y;
        if(map.containsKey(key))
            return map.get(key);

        if (x == matrix.length)
            return 0;

        int res = matrix[x][y] + process(matrix, x + 1, y, map);
        if (y - 1 >= 0)
            res = Math.min(res, matrix[x][y - 1] + process(matrix, x + 1, y - 1, map));

        if (y + 1 < matrix[0].length) {
            res = Math.min(res, matrix[x][y + 1] + process(matrix, x + 1, y + 1, map));
        }
        map.put(key, res);
        return res;
    }
}
