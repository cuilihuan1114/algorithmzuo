
import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/5/8 9:55
 */
public class Problem_0801_使序列递增的最小交换次数 {

    public static void main(String[] args) {
        System.out.println(new Problem_0801_使序列递增的最小交换次数().minSwap(new int[]{1,3,5,4}, new int[]{1,2,3,7}));
    }

    public int minSwap(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0)
            return 0;
        // 不换 true为换
        boolean flag = false;
        Map<String, Integer> map = new HashMap<>();
        return process(A, B, flag,0,map);
    }

    private int process(int[] A, int[] B, boolean flag, int index, Map<String, Integer> map) {
        String code = getCode(flag, index);
        if(map.containsKey(code))
            return map.get(code);
        if(index == A.length)
            return 0;
        int min = Integer.MAX_VALUE;
        int a1 = 0;
        int b1 = 0;
        if(index != 0){
            a1 = flag ? B[index - 1] : A[index - 1];
            b1 = flag ? A[index - 1] : B[index - 1];
        }

        if (index == 0 || (A[index] > a1 && B[index] > b1)) {
            int p1 = process(A, B, false, index + 1, map);
            if (p1 != Integer.MAX_VALUE)
                min = p1;
        }

        if (index == 0 || (A[index] > b1 && B[index] > a1)) {
            int p2 = process(A, B, true, index + 1, map);
            if (p2 != Integer.MAX_VALUE)
                min = Math.min(min, p2 + 1);
        }
        map.put(code, min);
        return min;
    }

    private String getCode(boolean flag, int index) {
        return flag + "_" + index;
    }

}
