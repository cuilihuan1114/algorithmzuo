import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/3/20 16:03
 */
public class Problem_0539_最小时间差 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("01:39");
        list.add("10:26");
        list.add("21:43");

        System.out.println(new Problem_0539_最小时间差().findMinDifference(list));
    }

    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.size() == 0)
            return 0;

        //优化
        if (timePoints.size() > 1440) {
            return 0;
        }

        int[] array = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            array[i] = getNum(timePoints.get(i));
        }

        Arrays.sort(array);
        int min = 24 * 60 + array[0] - array[array.length - 1];

        for (int i = 0; i < array.length; i++) {
            if (i != 0)
                min = Math.min(min, array[i] - array[i - 1]);
        }

        return min;
    }

    private int getNum(String s) {
        int num1 = 0;
        int num2 = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ':') {
                flag = true;
            } else if (flag) {
                num2 = num2 * 10 + s.charAt(i) - '0';
            } else
                num1 = num1 * 10 + s.charAt(i) - '0';
        }


        return num1 * 60 + num2;
    }
}