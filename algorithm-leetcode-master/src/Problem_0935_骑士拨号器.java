
import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/5/28 17:00
 */
public class Problem_0935_骑士拨号器 {

    public static void main(String[] args) {
        System.out.println(new Problem_0935_骑士拨号器().knightDialer(1));
    }

    int[][][] dp = new int[10][10][5000];
    public int knightDialer(int n) {
        int mod = 1_000_000_007;
        int[] x_d = {-2, -1, 1, 2, 1, 2, -1, -2};
        int[] y_d = {1, 2, 2, 1, -2, -1, -2, -1};

        int N = 3;
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ans += process(i, j, N, x_d, y_d, mod,n-1,dp);
                ans = ans % mod;
            }
        }

        ans += process(3, 1, N, x_d, y_d, mod,n-1,dp);
        ans = ans % mod;

        return ans;
    }

    private int process(int x, int y, int N, int[] x_d, int[] y_d, int mod, int index,int[][][] dp) {
        // 因为数据量很大 5000条左右 如果用hash的话 第一生成的code会很多 拼接字符串的时候耗时 同时map的存取会容易发生碰撞 时间复杂度会变高
        // 时间会减少10倍左右
//        String code = x + "_" + y + "_" + index;
//        if(map.containsKey(code))
//            return map.get(code);
        if(dp[x][y][index] != 0)
            return dp[x][y][index];

        if (!isValid(N, x, y)) {
            return 0;
        }
        if(index == 0)
            return 1;

        int ans = 0;
        for (int i = 0; i < x_d.length; i++) {
            ans += process(x + x_d[i], y + y_d[i], N,x_d, y_d, mod, index - 1,dp);
            ans = ans % mod;

        }
        dp[x][y][index] = ans;
        return ans;
    }

    private boolean isValid(int n, int x, int y) {
        if(x == 3 && y == 1)
            return true;
        if(x < 0 || y < 0 || x >= n || y >= n)
            return false;
        return true;
    }
}
