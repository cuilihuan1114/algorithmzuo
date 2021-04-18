import java.util.HashSet;
import java.util.Stack;

/**
 * @author cuilihuan
 * @data 2021/3/5 8:52
 */
public class Problem_0365_水壶问题 {

    public static void main(String[] args) {
        System.out.println(new Problem_0365_水壶问题().canMeasureWater(3, 5, 4));
    }


    public boolean canMeasureWater(int x, int y, int z) {
        HashSet<Long> set = new HashSet<>();

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();

            int remainX = cur[0];
            int remainY = cur[1];

            Long res = hash(remainX, remainY);
            if (set.contains(res))
                continue;

            if (remainX == z || remainY == z || remainX + remainY == z)
                return true;

            set.add(res);
            System.out.println("Long=" + res);
            System.out.println("String=" + getDecode(remainX, remainY));

            //x装满
            stack.push(new int[]{x, remainY});

            //y装满
            stack.push(new int[]{remainX, y});

            // x和y都装满
            stack.push(new int[]{x, y});

            //x清空
            stack.push(new int[]{0, remainY});

            //y清空
            stack.push(new int[]{remainX, 0});

            // x倒入Y当中 倒满或者倒空
            stack.push(new int[]{remainX - Math.min(remainX, y - remainY), remainY + Math.min(remainX, y - remainY)});

            //y倒入X当中 倒满或者倒空
            stack.push(new int[]{remainX + Math.min(remainY, x - remainX), remainY - Math.min(remainY, x - remainX)});

        }


        return false;
    }


    public long hash(int x, int y) {
        return (long) x * 1000001 + y;
    }


    private String getDecode(int x, int y) {
        return ((long) (x) * 1000001 + y) + "";
    }
}
