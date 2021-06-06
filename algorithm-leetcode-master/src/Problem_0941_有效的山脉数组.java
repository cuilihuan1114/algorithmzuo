
/**
 * @author cuilihuan
 * @data 2021/5/27 19:49
 */
public class Problem_0941_有效的山脉数组 {
    public boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length <= 2)
            return false;

        int i = 1;
        for (; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1])
                break;
        }

        if (i == 1 || i == arr.length)
            return false;

        for (; i < arr.length; i++) {
            if (arr[i - 1] <= arr[i])
                return false;
        }

        return true;
    }
}
