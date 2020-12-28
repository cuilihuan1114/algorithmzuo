/**
 * @author cuilihuan
 * @data 2020/12/24 10:01
 */
public class Problem_0134_加油站 {
    public static void main(String[] args) {
        System.out.println(new Problem_0134_加油站().canCompleteCircuit(new int[]{3, 3, 4}, new int[]{3, 4, 4}));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0;
        int n = cost.length;
        while (i < n) {
            int allGas = 0;
            int allCost = 0;
            int count = 0;
            int postition = i;
            while (count < n) {
                allGas += gas[postition];
                allCost += cost[postition];
                postition = postition == n - 1 ? 0 : postition + 1;
                if (allGas < allCost)
                    break;
                count++;
            }
            if (count == n)
                return i;
            else
                i = i + count + 1;
        }
        return -1;

    }
}
