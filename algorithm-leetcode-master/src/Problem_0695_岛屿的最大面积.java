/**
 * @author cuilihuan
 * @data 2021/3/24 8:52
 */
public class Problem_0695_岛屿的最大面积 {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, process(grid, i, j));
                }
            }
        }

        return max;
    }

    private int process(int[][] grid, int x, int y) {
        if (x == grid.length || x == -1)
            return 0;
        if (y == grid[0].length || y== -1)
            return 0;
        if(grid[x][y] == 0)
            return 0;
        int sum = 1;
        grid[x][y] = 0;
        sum += process(grid, x + 1, y);
        sum += process(grid, x - 1, y);
        sum += process(grid, x, y + 1);
        sum += process(grid, x, y - 1);
        return sum;
    }
}
