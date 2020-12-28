/**
 * @author cuilihuan
 * @data 2020/12/3 21:43
 */
public class Problem_0064_最小路径和 {
    public static void main(String[] args) {
        System.out.println(new Problem_0064_最小路径和().minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }

    //方式二 递归+缓存
    public int minPathSum(int[][] grid) {
        int[][] cache = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {
                cache[i][j] = -1;
            }
        }
        return process1(grid, 0, 0,cache);
    }

    private int process1(int[][] grid, int curX, int curY,int[][] cache) {
        if(cache[curX][curY]!=-1)
            return cache[curX][curY];
        if (curX == grid.length - 1 && curY == grid[0].length - 1)
            return grid[curX][curY];
        if (curX >= grid.length || curY >= grid[0].length)
            return -1;
        int sum = Integer.MAX_VALUE;
        int doDown = process1(grid, curX + 1, curY,cache);
        int doRight = process1(grid, curX, curY + 1,cache);
        if (doDown != -1)
            sum = doDown;
        if (doRight != -1)
            sum = Math.min(sum, doRight);
        cache[curX][curY] = (sum == Integer.MAX_VALUE ? -1 : sum + grid[curX][curY]);
        return cache[curX][curY];
    }


    public int minPathSum1(int[][] grid) {
        return process(grid, 0, 0);
    }

    private int process(int[][] grid, int curX, int curY) {
        if (curX == grid.length - 1 && curY == grid[0].length - 1)
            return grid[curX][curY];
        if (curX >= grid.length || curY >= grid[0].length)
            return -1;
        int sum = Integer.MAX_VALUE;
        int doDown = process(grid, curX + 1, curY);
        int doRight = process(grid, curX, curY + 1);
        if (doDown != -1)
            sum = doDown;
        if (doRight != -1)
            sum = Math.min(sum, doRight);
        return sum == Integer.MAX_VALUE ? -1 : sum + grid[curX][curY];
    }


}
