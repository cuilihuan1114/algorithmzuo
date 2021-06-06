
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/5/29 10:15
 */
public class Problem_0949_给定数字能组成的最大时间 {

    public static void main(String[] args) {
        System.out.println(new Problem_0949_给定数字能组成的最大时间().largestTimeFromDigits(new int[]{1, 2, 3, 4}));
    }
    public String largestTimeFromDigits(int[] arr) {
        if(arr == null || arr.length == 0)
            return "";
        List<int[]> list = new ArrayList<>();
        process(arr, list, 0);

        int max = 0;
        String res = "";
        for (int i = 0; i < list.size(); i++) {
            int[] time = list.get(i);
            if(isValid(time)){
                int ans = (time[0] * 10 + time[1]) * 60 + (time[2] * 10 + time[3]);
                if(max <= ans){
                    max = ans;
                    res = time[0] + "" + time[1] + ":" + time[2] + "" + time[3];
                }
            }
        }

        return res;
    }

    private boolean isValid(int[] time) {
        if(time[0] > 2)
            return false;
        if(time[0] == 2 && time[1] > 3)
            return false;

        if(time[2] > 5)
            return false;
        return true;
    }

    private void process(int[] arr, List<int[]> list, int index) {
        if(index == arr.length) {
            list.add(Arrays.copyOf(arr, arr.length));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            process(arr, list, index+1);
            swap(arr, index, i);
        }

    }

    private void swap(int[] arr, int index, int index1) {
        int tmp = arr[index];
        arr[index] = arr[index1];
        arr[index1] = tmp;
    }
}
