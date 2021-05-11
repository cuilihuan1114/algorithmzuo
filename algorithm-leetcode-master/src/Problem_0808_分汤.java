
import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/5/8 19:27
 */
public class Problem_0808_分汤 {


    public static void main(String[] args) {
        for (int i = 0; i < 100000000; i++) {

        System.out.println("i="+i+"_"+new Problem_0808_分汤().soupServings(i));
        }
    }

    public double soupServings(int N) {
        // 当很大的时候会无限接近1
        if(N > 7000)
            return 1;
        int[] A = {100, 75, 50, 25};
        int[] B = {0, 25, 50, 75};
        int remainA = N;
        int remainB = N;
        Map<String, Double> map = new HashMap<>();
        return process(A, B, remainA, remainB, map);
    }

    private double process(int[] A, int[] B, int remainA, int remainB, Map<String, Double> map) {
        String code = getCode(remainA, remainB);
        if (map.containsKey(code))
            return map.get(code);
        if (remainA == 0)
            return remainB != 0 ? 1 : 0.5;

        if (remainB == 0)
            return 0;

        double sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += 0.25 * process(A, B, Math.max(0, remainA - A[i]), Math.max(0, remainB - B[i]), map);
        }
        map.put(code, sum);
        return sum;
    }

    private String getCode(int remainA, int remainB) {
        return remainA + "_" + remainB;
    }
}
