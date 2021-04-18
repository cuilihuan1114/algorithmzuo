/**
 * @author cuilihuan
 * @data 2021/3/21 14:32
 */
public class Problem_0552_学生出勤记录II {
    public int checkRecord(int n) {

        int  flag = 0;
        int count = 0;
        long[][][] cache = new long[2][3][n + 1];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                for (int k = 0; k < cache[i][j].length; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        return process(n, flag, count, 0,cache);

    }

    private int process(int n, int flag, int count, int index, long[][][] cache) {
        if (index == n)
            return 1;

        if(cache[flag][count][index] != -1)
            return (int)cache[flag][count][index];
        long max = 0;

        if (flag == 0) {
            max = process(n, 1, 0, index + 1, cache);
        }

        if (count < 2)
            max += process(n, flag, count + 1, index + 1, cache);
        max += process(n, flag, 0, index + 1, cache);
        max = max % ((int) Math.pow(10, 9) + 7);
        cache[flag][count][index] = max;
        return (int)max;

    }


}
