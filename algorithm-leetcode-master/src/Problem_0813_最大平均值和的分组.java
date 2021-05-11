
import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/5/9 15:09
 */
public class Problem_0813_最大平均值和的分组 {
    public static void main(String[] args) {
        System.out.println(new Problem_0813_最大平均值和的分组().largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3));
    }

    public double largestSumOfAverages(int[] A, int K) {
        int[] sumDp = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            sumDp[i] = (i > 0 ? sumDp[i - 1] : 0) + A[i];
        }
        Map<String, Double> map = new HashMap<>();
        return process(A, sumDp, K, 0, map);
    }

    private double process(int[] A, int[] sumDp, int index, int start, Map<String, Double> map) {

        String code = getCode(index, start);
        if(map.containsKey(code))
            return map.get(code);
        if (index == 0) {
            return (start == A.length) ? 0 : -1;
        }
        if (start == A.length)
            return -1;

        double average = 0.0;
        for (int i = start; i < (A.length - (index - 1)); i++) {
            double p1 = process(A, sumDp, index - 1, i + 1, map);
            if (p1 < 0)
                continue;
            average = Math.max(average, p1 + (double) (sumDp[i] - sumDp[start] + A[start]) / (i - start + 1));
        }
        map.put(code, average);
        return average;
    }

    private String getCode(int index, int start) {
        return index + "_" + start;
    }
}
