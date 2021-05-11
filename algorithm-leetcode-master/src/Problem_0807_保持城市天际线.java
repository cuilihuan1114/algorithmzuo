
/**
 * @author cuilihuan
 * @data 2021/5/8 19:14
 */
public class Problem_0807_保持城市天际线 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int[] row = new int[grid.length];

        int[] col = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                col[i] = Math.max(col[i], grid[j][i]);
            }
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                count += Math.max(Math.min(row[i] - grid[i][j], col[j] - grid[i][j]), 0);
            }
        }
        return count;
    }
}
