import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/4/9 10:26
 */
public class Problem_0741_摘樱桃 {
    public static void main(String[] args) {
        System.out.println(new Problem_0741_摘樱桃().cherryPickup(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 1, 1}}));
    }

    public int cherryPickup(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        Map<String, Integer> map = new HashMap<>();
        int ans = process(grid, 0, 0, 0, 0, map);

        return ans == -1 ? 0 : ans;
    }


    private int process(int[][] grid, int x1, int y1, int x2, int y2, Map<String, Integer> map) {

        String code = getCode(x1, y1, x2, y2);
        if (map.containsKey(code))
            return map.get(code);

        if (x1 == grid.length - 1 && y1 == grid.length - 1 && x2 == grid.length - 1 && y2 == grid.length - 1)
            return grid[x1][y1];

        if (x1 >= grid.length || y1 >= grid.length || x2 >= grid.length || y2 >= grid.length)
            return -1;

        int cur1 = grid[x1][y1];
        int cur2 = grid[x2][y2];

        if (x1 == x2 && y1 == y2)
            cur2 = 0;

        if (cur1 == -1 || cur2 == -1)
            return -1;

        grid[x1][y1] = 0;
        grid[x2][y2] = 0;

        int p = -1;
        int sum = cur1 + cur2;
        int p1 = process(grid, x1 + 1, y1, x2 + 1, y2, map);
        p = Math.max(p, p1);
        int p2 = process(grid, x1 + 1, y1, x2, y2 + 1, map);
        p = Math.max(p, p2);
        int p3 = process(grid, x1, y1 + 1, x2, y2 + 1, map);
        p = Math.max(p, p3);
        int p4 = process(grid, x1, y1 + 1, x2 + 1, y2, map);
        p = Math.max(p, p4);

        grid[x2][y2] = cur2;
        grid[x1][y1] = cur1;
        if (p == -1) {
            map.put(code, -1);
            return -1;
        }
        map.put(code, sum + p);
        return sum + p;
    }

    private String getCode(int x1, int y1, int x2, int y2) {
        return x1 + "_" + y1 + "_" + x2 + "_" + y2;
    }
}