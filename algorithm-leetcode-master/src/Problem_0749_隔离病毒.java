import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cuilihuan
 * @data 2021/4/12 14:40
 */
public class Problem_0749_隔离病毒 {
    public static void main(String[] args) {
        //        System.out.println(new Problem_0749_隔离病毒().containVirus(new int[][]{
        //                {0, 1, 1, 1, 1, 0, 1, 1, 0, 0},
        //                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
        //                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
        //                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
        //                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        //                {0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
        //                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        //                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
        //                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
        //                {0, 0, 1, 0, 0, 0, 0, 0, 1, 0}}));
        //        System.out.println(new Problem_0749_隔离病毒().containVirus(new int[][]{{0, 1, 0, 0, 0, 0, 0, 1},
        //                {0, 1, 0, 0, 0, 0, 0, 1},
        //                {0, 0, 0, 0, 0, 0, 0, 1},
        //                {0, 0, 0, 0, 0, 0, 0, 0}}));

        System.out.println(new Problem_0749_隔离病毒().containVirus(new int[][]{
                {0, 1, 0, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 1, 0, 0, 1, 1, 0},
                {0, 1, 0, 0, 1, 0, 1, 1, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                {0, 1, 0, 1, 0, 0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0, 1, 1, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 0, 1, 0, 1}}));

    }

    public int containVirus(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        Set<String> set = new HashSet<>();

        int[][] serial = new int[grid.length][grid[0].length];
        List<Info> areaOneNum = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && serial[i][j] == 0) {
                    HashSet<String> access = new HashSet<>();
                    getPosOne(grid, i, j, serial, i * grid.length + j, access);
                    areaOneNum.add(new Info(i, j));
                }
            }
        }

        while (true) {
            int[] pos = getMax(grid, areaOneNum, set);
            if (pos[0] == -1)
                break;
            addFirx(grid, pos[0], pos[1], set);
            infection(grid, areaOneNum, set);
        }

        return set.size();
    }

    private void getPosOne(int[][] grid, int x, int y, int[][] serial, int flag, HashSet<String> access) {

        if (x >= grid.length || y >= grid[0].length || x < 0 || y < 0)
            return;
        if (grid[x][y] == 0 || grid[x][y] == -2)
            return;

        String s = x + "_" + y;
        if (access.contains(s))
            return;
        access.add(s);
        serial[x][y] = flag;
        getPosOne(grid, x + 1, y, serial, flag, access);
        getPosOne(grid, x, y + 1, serial, flag, access);
        getPosOne(grid, x - 1, y, serial, flag, access);
        getPosOne(grid, x, y - 1, serial, flag, access);

    }

    class Info {
        int x;
        int y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void infection(int[][] grid, List<Info> areaOneNum, Set<String> set) {
        List<Info> list = new ArrayList<>();

        for (int k = 0; k < areaOneNum.size(); k++) {
            Info cur = areaOneNum.get(k);
            int i = cur.x;
            int j = cur.y;
            if (grid[i][j] == 1) {
                HashSet<String> access = new HashSet<>();
                infeArea(grid, 0, 0, i, j, set, list, access);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            grid[list.get(i).x][list.get(i).y] = 1;
        }

    }

    private void infeArea(int[][] grid, int preX, int preY, int x, int y, Set<String> set, List<Info> list, HashSet<String> access) {
        if (x >= grid.length || y >= grid[0].length || x < 0 || y < 0)
            return;
        if (grid[x][y] == -1 || grid[x][y] == -2)
            return;

        if (grid[x][y] == 0) {
            String vireCode = getCode(preX, preY, x, y);
            if (!set.contains(vireCode)) {
                list.add(new Info(x, y));
            }
            return;
        }

        String s = x + "_" + y;
        if (access.contains(s))
            return;
        access.add(s);

        grid[x][y] = -1;
        infeArea(grid, x, y, x + 1, y, set, list, access);
        infeArea(grid, x, y, x, y + 1, set, list, access);
        infeArea(grid, x, y, x - 1, y, set, list, access);
        infeArea(grid, x, y, x, y - 1, set, list, access);
        grid[x][y] = 1;

    }

    private void addFirx(int[][] grid, int x, int y, Set<String> set) {
        if (x >= grid.length || y >= grid[0].length || x < 0 || y < 0)
            return;
        if (grid[x][y] == 0 || grid[x][y] == -2)
            return;

        grid[x][y] = -2;
        addFirx(grid, x + 1, y, set);
        addFirx(grid, x, y + 1, set);
        addFirx(grid, x - 1, y, set);
        addFirx(grid, x, y - 1, set);


    }

    private int[] getMax(int[][] grid, List<Info> areaOneNum, Set<String> set) {
        int cur = 0;
        int[] res = {-1, -1};
        Set<String> maxSet = null;

        int pos = -1;
        for (int k = 0; k < areaOneNum.size(); k++) {
            Info info = areaOneNum.get(k);
            int i = info.x;
            int j = info.y;
            if (grid[i][j] == 1) {
                Set<String> exist = new HashSet<>();
                HashSet<String> access = new HashSet<>();
                HashSet<String> zeroSet = new HashSet<>();
                vireArea(grid, -1, -1, i, j, exist, set, access, zeroSet);
                if (zeroSet.size() > cur) {
                    pos = k;
                    cur = zeroSet.size();
                    maxSet = exist;
                    res[0] = i;
                    res[1] = j;
                }
            }

        }

        if (maxSet != null) {
            set.addAll(maxSet);
            areaOneNum.remove(pos);
        }
        return res;
    }

    private void vireArea(int[][] grid, int preX, int preY, int x, int y, Set<String> exist, Set<String> set, HashSet<String> access, HashSet<String> zeroSet) {


        if (x >= grid.length || y >= grid[0].length || x < 0 || y < 0)
            return;
        if (grid[x][y] == -1 || grid[x][y] == -2)
            return;

        if (grid[x][y] == 0) {
            String vireCode = getCode(preX, preY, x, y);
            zeroSet.add(x + "_" + y);
            if (!set.contains(vireCode) && !exist.contains(vireCode)) {
                exist.add(vireCode);
            }
            return;
        }

        String s = x + "_" + y;
        if (access.contains(s))
            return;
        access.add(s);


        grid[x][y] = -1;
        vireArea(grid, x, y, x + 1, y, exist, set, access, zeroSet);
        vireArea(grid, x, y, x, y + 1, exist, set, access, zeroSet);
        vireArea(grid, x, y, x - 1, y, exist, set, access, zeroSet);
        vireArea(grid, x, y, x, y - 1, exist, set, access, zeroSet);
        grid[x][y] = 1;

    }

    private String getCode(int preX, int preY, int x, int y) {
        return preX + "_" + preY + "_" + x + "_" + y;
    }
}