import java.util.HashMap;

/**
 * Created by CUI on 2021/1/4
 */
public class Problem_0149_直线上最多的点数 {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0)
            return 0;
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int curMax = 0;
            int same = 0;
            int xPoint = 0;
            int yPoint = 0;
            for (int j = i + 1; j < points.length; j++) {
                //相同的
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    same++;
                //斜率为0
                } else if (points[i][0] == points[j][0]) {
                    xPoint++;
                //斜率不存在
                } else if (points[i][1] == points[j][1])
                    yPoint++;
                else {
                    int x = points[i][0] - points[j][0];
                    int y = points[i][1] - points[j][1];
                    //进行约分
                    int gcd = gcd(x, y);
                    x = x / gcd;
                    y = y / gcd;
                    //防止有负数
                    boolean flag = false;
                    if (x < 0) {
                        x = -x;
                        flag = true;
                    }
                    if (y < 0) {
                        y = -y;
                        flag = true;
                    }
                    String s = y + "_" + x;
                    if (flag) {
                        s = "-" + s;
                    }
                    if (map.containsKey(s)) {
                        int point = map.get(s) + 1;
                        map.put(s, point);
                        curMax = Math.max(curMax, point);
                    } else {
                        map.put(s, 1);
                        curMax = Math.max(curMax, 1);
                    }
                }
            }
            curMax = Math.max(curMax, Math.max(xPoint, yPoint)) + same + 1;
            max = Math.max(max, curMax);
        }
        return max;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
