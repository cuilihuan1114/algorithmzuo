
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/5/9 19:18
 */
public class Problem_0845_数组中的最长山脉 {
    public int longestMountain(int[] arr) {
        if(arr == null || arr.length == 0)
            return 0;

        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        for (int i = 0; i < left.length; i++) {
            left[i] = i > 0 ? (arr[i] - arr[i - 1] > 0 ? left[i - 1] + 1 : 0) : 0;
        }

        for (int i = right.length - 1; i >= 0 ; i--) {
            right[i] = (i != right.length - 1 ? (arr[i] - arr[i + 1] > 0 ? right[i + 1] + 1 : 0) : 0);
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(left[i] == 0 || right[i] == 0)
                continue;

            max = Math.max(left[i] + right[i] + 1, max);
        }
        if(max <= 2)
            max = 0;
        return max;
    }
}
