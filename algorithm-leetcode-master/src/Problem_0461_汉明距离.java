/**
 * @author cuilihuan
 * @data 2021/3/16 10:09
 */
public class Problem_0461_汉明距离 {
    public int hammingDistance(int x, int y) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        int count = 0;
        while (min != 0){
            count += ((max ) & 1) ^ ((min) & 1);
            max = max >> 1;
            min = min >> 1;
        }

        while (max != 0){
            count += ((max & 1) == 1 ? 1 : 0);
            max = max >> 1;
        }

        return count;


    }
}
