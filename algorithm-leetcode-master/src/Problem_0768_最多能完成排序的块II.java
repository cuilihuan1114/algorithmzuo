/**
 * @author cuilihuan
 * @data 2021/4/13 18:59
 */
public class Problem_0768_最多能完成排序的块II {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int[] left = new int[arr.length];

        for (int i = 0; i < left.length; i++) {
            int cur = arr[i];
            int pos = i;
            for (int j = i + 1; j < left.length; j++) {
                if (arr[j] < cur) {
                    pos = j;
                }
            }
            left[i] = pos;
        }

        int sum = 0;
        int max = 0;
        for (int i = 0; i < left.length; i++) {
            max = Math.max(max, left[i]);
            if (max == i)
                sum++;
        }
        return sum;
    }
}