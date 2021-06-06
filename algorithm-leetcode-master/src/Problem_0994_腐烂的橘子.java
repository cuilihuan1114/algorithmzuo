
import java.util.*;

/**
 * @author cuilihuan
 * @data 2021/5/31 9:34
 */
public class Problem_0994_腐烂的橘子 {
    class Info {
        int x;
        int y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + "_" + y;
        }
    }

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        Set<String> all = new HashSet<>();
        List<Info> curList = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 2) {
                    all.add(i + "_" + j);
                    ans++;
                    curList.add(new Info(i, j));
                } else if(grid[i][j] == 1)
                    ans++;
            }
        }

        int[] xC = new int[]{1, -1, 0, 0};
        int[] yC = new int[]{0, 0, 1, -1};

        int res = 0;
        boolean flag = true;
        while (!curList.isEmpty()){
            List<Info> tmp = new ArrayList<>();
            flag = false;
            res++;
            for(Info info : curList){
                for (int i = 0; i < xC.length; i++) {
                    int x = info.x + xC[i];
                    int y = info.y + yC[i];
                    if(x < 0  || y < 0 || x >= grid.length || y >= grid[0].length)
                        continue;
                    String code = x + "_" + y;
                    if(!all.contains(code) && grid[x][y] == 1){
                        all.add(code);
                        tmp.add(new Info(x, y));
                    }
                }
            }
            curList = tmp;
        }

        if(ans != all.size())
            res = -1;
        else if(!flag)
            res--;

        return res;



    }
}
