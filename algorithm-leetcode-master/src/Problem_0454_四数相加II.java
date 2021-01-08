import java.util.HashMap;

/**
 * Created by CUI on 2021/1/2
 */
public class Problem_0454_四数相加II {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (hashMap.containsKey(sum)) {
                    hashMap.put(sum, hashMap.get(sum) + 1);
                }else
                    hashMap.put(sum, 1);
            }
        }
        
        int all = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = -(C[i] + D[j]);
                if (hashMap.containsKey(sum)) {
                    all += hashMap.get(sum);
                }
            }
        }
        return all;
    }
}
