import java.util.Arrays;

/**
 * @author cuilihuan
 * @data 2021/3/15 8:59
 */
public class Problem_0475_供暖器 {
    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length == 0)
            return 0;
        int max = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int cur = Integer.MAX_VALUE;
        for (int i = 0; i < houses.length; i++) {
            max = Math.max(max, getB(houses[i], heaters));
        }
        return max;
    }

    private int getB(int house, int[] heaters) {
        int left = 0;
        int right = heaters.length - 1;
        int middle = 0;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (heaters[middle] < house) {
                left = middle + 1;
            } else if (heaters[middle] > house) {
                right = middle - 1;
            } else
                break;
        }
        int cur = Integer.MAX_VALUE;
        if (middle + 1 <= heaters.length - 1)
            cur = Math.min(cur, Math.abs(heaters[middle + 1] - house));
        cur = Math.min(cur, Math.abs(heaters[middle] - house));
        if (middle - 1 >= 0)
            cur = Math.min(cur, Math.abs(heaters[middle - 1] - house));

        return cur;
    }


}