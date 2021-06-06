
import java.util.Arrays;

/**
 * @author cuilihuan
 * @data 2021/5/28 14:35
 */
public class Problem_0923_三数之和的多种可能 {
    public int threeSumMulti(int[] arr, int target) {
        if(arr == null || arr.length == 0)
            return 0;

        int ans = 0;
        int mod = 1_000_000_007;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            int T = target - arr[i];
            while ( j < k){
                if(arr[j] + arr[k] < T)
                    j++;
                else if(arr[j] + arr[k] > T)
                    k--;
                else if(arr[j] != arr[k]){
                    int left = 1;
                    while (arr[j] == arr[j+1]){
                        j++;
                        left++;
                    }

                    int right = 1;
                    while (arr[k] == arr[k-1]){
                        right++;
                        k--;
                    }

                    ans = (ans + left * right) % mod;
                    j++;
                    k--;

                }else {
                    ans = (ans + (k - j + 1) * (k - j) / 2) % mod ;
                    break;
                }
            }
        }
        return ans;
    }
}
