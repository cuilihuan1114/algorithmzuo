import java.util.HashMap;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/4/13 21:26
 */
public class Problem_0790_多米诺和托米诺平铺 {

    public static void main(String[] args) {
        System.out.println(new Problem_0790_多米诺和托米诺平铺().numTilings(7));
    }


    public int numTilings(int N) {
        if (N == 0)
            return 0;
        Map<String, Integer> map = new HashMap<>();
        return process1(N, 0, 0, map);
    }

    //方法1 时间为O(n2)
    private int process1(int N, int first, int second, Map<String, Integer> map) {

        String code = getCode(first, second);

        if (map.containsKey(code))
            return map.get(code);

        if (first == N && second == N)
            return 1;

        if (first > N || second > N)
            return 0;

        long sum = 0;

        if (first - second >= 2) {
            second = second + 2;
            sum += process1(N, first, second, map);
        } else if (second - first >= 2) {
            first = first + 2;
            sum += process1(N, first, second, map);
        } else if (first - second == 1) {
            sum += process1(N, first + 1, first + 1, map);
            sum += process1(N, first + 2, second, map);
            sum += process1(N, first + 2, first + 2, map);
        } else if (second - first == 1) {
            sum += process1(N, second + 1, second + 1, map);
            sum += process1(N, first + 2, second, map);
        } else if (second == first) {
            sum += process1(N, first + 1, second + 1, map);
            sum += process1(N, first + 2, second, map);
            sum += process1(N, first + 1, second + 2, map);
            sum += process1(N, first + 2, second + 1, map);
        }
        sum = sum % ((int) (Math.pow(10, 9)) + 7);
        map.put(code, Math.toIntExact(sum));
        return Math.toIntExact(sum);
    }

    private String getCode(int first, int second) {
        return first + "_" + second;
    }
}
