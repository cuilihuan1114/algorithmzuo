
import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/5/25 9:31
 */
public class Problem_0873_最长的斐波那契子序列的长度 {

    public static void main(String[] args) {
        System.out.println(new Problem_0873_最长的斐波那契子序列的长度().lenLongestFibSubseq(new int[]{2, 4, 5, 6, 7, 8, 11, 13, 14, 15, 21, 22, 34}));
    }


    public int lenLongestFibSubseq(int[] arr) {
        if (arr == null || arr.length < 2)
            return 0;

        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            record.put(arr[i], i);
        }

        Map<Integer, Integer> longest = new HashMap<>();

        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int index = record.getOrDefault(arr[i] - arr[j], -1);
                if (index >= 0 && index < j) {
                    int res = longest.getOrDefault(index * arr.length + j, 2) + 1;
                    longest.put(j * arr.length + i, res);
                    ans = Math.max(ans, res);
                }
            }
        }
        return ans >= 3 ? ans  : 0;
    }
}
