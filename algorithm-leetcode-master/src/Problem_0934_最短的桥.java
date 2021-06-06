
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author cuilihuan
 * @data 2021/5/27 19:13
 */
public class Problem_0934_最短的桥 {
    public static void main(String[] args) {
        System.out.println(new Problem_0934_最短的桥().shortestBridge(new int[][]{{0,1,0},{0,0,0},{0,0,1}}));
    }


    public int shortestBridge(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int res = 0;

        HashMap<Integer, int[]> ans = new HashMap<>();
        HashMap<Integer, int[]> startMap = new HashMap<>();
        HashMap<Integer, int[]> endMap = new HashMap<>();

        int flag = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (flag == 0 && grid[i][j] == 1) {
                    process(grid, i, j, startMap);
                    flag = 1;
                }
                if (flag == 1 && grid[i][j] == 1) {
                    process(grid, i, j, endMap);
                    flag = 2;
                    break;
                }
            }
            if (flag == 2)
                break;
        }
        int[] xOp = {1, -1, 0, 0};
        int[] yOp = {0, 0, 1, -1};
        ans.putAll(startMap);
        while (!startMap.isEmpty()) {
            HashMap<Integer, int[]> midMap = new HashMap<>();
            for (Integer key : startMap.keySet()) {
                int[] value = startMap.get(key);

                for (int i = 0; i < xOp.length; i++) {
                    int x = xOp[i] + value[0];
                    int y = yOp[i] + value[1];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length) {
                        int indetify = getIndefiy(grid, x, y);
                        if (endMap.containsKey(indetify))
                            return res;
                        if (!ans.containsKey(indetify)) {
                            midMap.put(indetify, new int[]{x, y});
                        }
                    }
                }
            }
            ans.putAll(midMap);
            startMap = midMap;
            res++;

        }

        return -1;


    }

    private Integer getIndefiy(int[][] grid, int x, int y) {
        return x * grid[0].length + y;
    }

    private void process(int[][] grid, int x, int y, HashMap<Integer, int[]> set) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
            return;
        if (grid[x][y] == 2 || grid[x][y] == 0)
            return;

        grid[x][y] = 2;
        set.put(x * grid[0].length + y, new int[]{x, y});
        process(grid, x + 1, y, set);
        process(grid, x - 1, y, set);
        process(grid, x, y - 1, set);
        process(grid, x, y + 1, set);

    }
}
