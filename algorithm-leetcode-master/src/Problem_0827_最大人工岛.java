
import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/5/10 18:57
 */
public class Problem_0827_最大人工岛 {

    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int index = 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    map.put(index, process1(grid, i, j, index++));
                }
            }
        }

        int max = 0;
        boolean flag = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    flag = true;
                    max = Math.max(max, findNeigbor(grid, i, j, map));
                }
            }
        }

        return !flag ? grid.length * grid[0].length : max;

    }

    private int findNeigbor(int[][] grid, int x, int y, Map<Integer, Integer> map) {
        HashSet<Integer> set = new HashSet<>();
        if (x + 1 < grid.length) {
            set.add(grid[x + 1][y]);
        }
        if (x - 1 >= 0) {
            set.add(grid[x - 1][y]);
        }
        if (y + 1 < grid[0].length) {
            set.add(grid[x][y + 1]);
        }
        if (y - 1 >= 0) {
            set.add(grid[x][y - 1]);
        }

        int count = 1;
        for(Integer key : set){
            count += map.getOrDefault(key, 0);
        }
        return count;
    }

    private int process1(int[][] grid, int x, int y, int index) {
        if (x < 0 || x == grid.length || y < 0 || y == grid[0].length)
            return 0;
        if (grid[x][y] != 1)
            return 0;

        int sum = 1;
        grid[x][y] = index;

        sum += process1(grid, x + 1, y, index);
        sum += process1(grid, x, y + 1, index);
        sum += process1(grid, x - 1, y, index);
        sum += process1(grid, x, y - 1, index);
        return sum;
    }




    //超时了 这个方法的时间复杂度为O(N^4) 通过了70/75的测试用例
    public int largestIsland1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int max = 0;
        boolean flag = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    flag = false;
                    HashSet<String> set = new HashSet<>();
                    grid[i][j] = 1;
                    max = Math.max(max, process(grid, i, j, set));
                    grid[i][j] = 0;
                }
            }
        }

        return flag ? grid.length * grid[0].length : max;
    }

    private int process(int[][] grid, int x, int y, HashSet<String> set) {
        if (x < 0 || x == grid.length || y < 0 || y == grid[0].length)
            return 0;
        String code = x + "_" + y;
        if (set.contains(code))
            return 0;
        set.add(code);

        int sum = 0;
        if (grid[x][y] == 1) {
            sum += 1;
        }

        if (grid[x][y] == 0)
            return 0;

        sum += process(grid, x + 1, y, set);
        sum += process(grid, x, y + 1, set);
        sum += process(grid, x - 1, y, set);
        sum += process(grid, x, y - 1, set);

        return sum;
    }


}
