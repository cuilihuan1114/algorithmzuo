/**
 * @author cuilihuan
 * @data 2021/3/21 17:19
 */
public class Problem_0605_种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;
        if (flowerbed == null || flowerbed.length == 0)
            return false;
        boolean[] flag = new boolean[flowerbed.length];
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                if (i != 0) flag[i - 1] = true;
                if (i != flowerbed.length - 1) flag[i + 1] = true;
                flag[i] = true;
            }
        }

        int sum = 0;
        for (int i = 0; i < flag.length; i++) {
            if (!flag[i]) {
                count++;
                if (i != flowerbed.length - 1) flag[i + 1] = true;
            }
        }
        return count >= n;


    }
}