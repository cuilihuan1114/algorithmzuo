/**
 * @author cuilihuan
 * @data 2021/4/14 9:38
 */
public class Problem_0780_到达终点 {


    public static void main(String[] args) {
        System.out.println(new Problem_0780_到达终点().reachingPoints(2, 3, 4, 7));
    }

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return true;
        }

        return process(sx, sy, tx, ty);

    }

    private boolean process(int sx, int sy, int tx, int ty) {

        if (sx == tx && sy == ty) {
            return true;
        }
        if (sx > tx || sy > ty) {
            return false;
        }

        if (tx > ty) {

            if (ty > sy)
                return process(sx, sy, tx % ty, ty);
            else
                return (tx - sx) % ty == 0;
        } else {

            if (tx > sx)
                return process(sx, sy, tx, ty % tx);
            else
                return (ty - sy) % tx == 0;
        }

    }


}