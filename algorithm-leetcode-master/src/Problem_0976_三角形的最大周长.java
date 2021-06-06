
import java.util.Arrays;

/**
 * @author cuilihuan
 * @data 2021/5/30 16:37
 */
public class Problem_0976_三角形的最大周长 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for(int i = A.length - 1; i >= 2; i--) {
            int a = A[i];
            int b = A[i - 1];
            int c = A[i - 2];
            if(a < b + c){
                return a + b + c;
            }
        }
        return 0;

    }
}
