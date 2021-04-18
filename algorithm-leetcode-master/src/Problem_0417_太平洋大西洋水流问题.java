import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/3/7 11:08
 */
public class Problem_0417_太平洋大西洋水流问题 {

    public static void main(String[] args) {
        System.out.println(new Problem_0417_太平洋大西洋水流问题().pacificAtlantic(new int[][]{
                {4, 1, 16},
                {12, 3, 14},
                {14, 3, 11},
        }).size());
    }


    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        HashMap<String, Integer> taipin = new HashMap<>();
        HashMap<String, Integer> daxi = new HashMap<>();
        List<List<Integer>> cur = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (process(matrix, i, j, taipin, true) ) {
                    if (process(matrix, i, j, daxi, false)) {
                        List<Integer> add = new ArrayList<>();
                        add.add(i);
                        add.add(j);
                        cur.add(add);
                    }else
                        daxi.put(hash(i, j), -1);
                }else
                    taipin.put(hash(i, j), -1);
            }
        }

        return cur;

    }

    private boolean process(int[][] matrix, int x, int y, HashMap<String, Integer> map, boolean flag) {

        if (flag) {
            if (x == 0 || y == 0)
                return true;
            if (x > matrix.length - 1 || y > matrix[0].length - 1)
                return false;
        } else {
            if (x == matrix.length - 1 || y == matrix[0].length - 1)
                return true;
            if (x < 0 || y < 0)
                return false;
        }

        if (matrix[x][y] == -1)
            return false;

        String hash = hash(x, y);
        if (map.containsKey(hash))
            return map.get(hash) == 1;

        int old = matrix[x][y];
        matrix[x][y] = -1;
        boolean res = false;
        if (x + 1 < matrix.length && old >= matrix[x + 1][y] && process(matrix, x + 1, y, map, flag)) {
            res = true;
        }

        if (!res && x - 1 >= 0 && old >= matrix[x - 1][y] && process(matrix, x - 1, y, map, flag)) {
            res = true;
        }

        if (!res && y + 1 < matrix[0].length && old >= matrix[x][y + 1] && process(matrix, x, y + 1, map, flag)) {
            res = true;
        }


        if (!res && y - 1 >= 0 && old >= matrix[x][y - 1] && process(matrix, x, y - 1, map, flag)) {
            res = true;
        }

        matrix[x][y] = old;
        if(res){
            map.put(hash, 1);
        }
        return res;
    }

    public String hash(int x, int y) {
        return "x:" + x + "_" + "y:" + y;
    }
}
