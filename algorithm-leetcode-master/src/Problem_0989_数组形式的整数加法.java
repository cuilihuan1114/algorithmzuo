
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/6/1 16:22
 */
public class Problem_0989_数组形式的整数加法 {
    public static void main(String[] args) {
        System.out.println(new Problem_0989_数组形式的整数加法().addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                1));
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        int len = A.length;
        int lastNum = K;
        LinkedList<Integer> ret = new LinkedList<>();

        int i = len - 1;
        while (i >= 0 || lastNum > 0) {
            if (i >= 0) {
                lastNum += A[i];
            }
            ret.addFirst(lastNum % 10);
            lastNum /= 10;
            i--;
        }

        return ret;
    }
}
