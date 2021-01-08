import sun.awt.image.GifImageDecoder;

/**
 * Created by CUI on 2021/1/6
 */
public class Problem_0200_岛屿数量 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    process(grid, i, j);
                    count++;

                }
            }
        }
        return count;
    }

    private void process(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j<0 || j >= grid[0].length)
            return;
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            process(grid, i + 1, j);
            process(grid, i-1, j);
            process(grid, i, j + 1);
            process(grid, i, j-1);
        }
    }
}
