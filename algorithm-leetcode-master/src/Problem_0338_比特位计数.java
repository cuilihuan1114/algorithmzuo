/**
 * @author cuilihuan
 * @data 2021/3/4 15:51
 */
public class Problem_0338_比特位计数 {
    public int[] countBits(int num) {
        int[] count = new int[num + 1];
        count[0] = -1;
        int high = 0;
        for (int i = 0; i <= num; i++) {
            if((i & (i-1)) == 0)
                high = i;
            count[i] = count[i - high] + 1;
        }
        return count;
    }
}
