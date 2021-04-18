import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author cuilihuan
 * @data 2021/3/11 20:16
 */
public class Problem_0446_等差数列划分2_子序列 {

    public static void main(String[] args) {
        System.out.println(new Problem_0446_等差数列划分2_子序列().numberOfArithmeticSlices(new int[]{46,4,8,89,90,65,13,21,44,78,29,3,72,60,27,18,55,52,78,22,29,99,56,82,68,62,43,33,18,24,70,76,87,53,71,92,36,86,4,62,62,39,32,9,18,96,67,24,34,56,89,48,14,45,11,97,92,59,1,12,85,6,79,45,43,12,52,65,57,36,63,57,43,65,44,10,46,56,68,70,10,56,26,37,12,7,74,58,49,45,63,74,91,72,94,76,80,60,86,99}));
    }

    public int numberOfArithmeticSlices(int[] A){
        if (A == null || A.length == 0)
            return 0;

        HashMap<Integer, Integer>[] map = new HashMap[A.length];

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long dela = (long) A[i] - (long) A[j];
                int diff = (int) dela;
                int ans = map[j].getOrDefault(diff, 0);
                sum += ans;
                int ans1 = map[i].getOrDefault(diff, 0);
                map[i].put(diff, ans + ans1 + 1);
            }
        }
        return sum;
    }


    public int numberOfArithmeticSlices3(int[] A, Map<Integer,Integer> map,int index){


        return 0;
    }



    public int numberOfArithmeticSlices2(int[] A) {
        if (A == null || A.length == 0)
            return 0;


        int sum = 0;
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                set.add((long) A[j] - (long) A[i]);
            }
        }

        for (Long step : set) {
            int[][][] cache = new int[A.length + 1][A.length + 1][A.length];

            sum += process2(A, 0, -1, step, 0, cache); // 7 5
        }
        return sum;
    }

    public int process2(int[] A, int index, int pre, long dis, int count, int[][][] cache) { // count > 2
        if (index == A.length)
            return count > 2 ? 1 : 0;

        int sum = 0;
        int target = Math.min(count, 3);

        if (pre != -1) {
            if (cache[index][pre][target] > 0) {
                return cache[index][pre][target];
            }
        }

        if (pre == -1) {
            sum += process2(A, index + 1, index, dis, count + 1, cache);
        } else if ((long) A[index] - (long) A[pre] == dis) {
            sum += process2(A, index + 1, index, dis, count + 1, cache);
        }

        sum += process2(A, index + 1, pre, dis, count, cache);

        if (pre != -1) {
            if(count > 2)
                cache[index][pre][3] = sum;
            else
                cache[index][pre][count] = sum;

        }
        return sum;
    }


    public int numberOfArithmeticSlices1(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                sum += process1(A, j + 1, A[j], (long) A[j] - A[i], 2);
            }
        }
        return sum;
    }

    public int process1(int[] A, int index, long pre, long dis, int count) {
        if (index == A.length)
            return count > 2 ? 1 : 0;

        int sum = 0;
        if (A[index] - pre == dis) {
            sum += process1(A, index + 1, A[index], dis, count + 1);
        }

        sum += process1(A, index + 1, pre, dis, count);

        return sum;
    }
}
