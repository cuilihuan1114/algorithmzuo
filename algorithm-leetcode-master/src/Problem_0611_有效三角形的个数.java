
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author cuilihuan
 * @data 2021/3/22 9:01
 */
public class Problem_0611_有效三角形的个数 {


    int binarySearch(int nums[], int l, int r, int x) {
        while (l <= r) {
            int middle = l + (r - l) / 2;
            if (nums[middle] >= x) {
                r = middle - 1;
            } else
                l = middle + 1;
        }
        return l;
    }

    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
                count += k - j - 1;
            }
        }
        return count;
    }


    public int triangleNumber2(int[] nums) {
        int count = 0;
        //暴力解一般是三次方 所以在这里一般弄个排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;
                count += k - j - 1;
            }
        }
        return count;
    }


    public int triangleNumber1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int index = 0;
        int curPos = 0;
        int[] array = new int[3];
        HashMap<String, Integer> map = new HashMap<>();
        return process(nums, index, curPos, array, map);
    }

    private int process(int[] nums, int index, int curPos, int[] array, HashMap<String, Integer> map) {

        String code = getHashCode(curPos, array);
        if (map.containsKey(code))
            return map.get(code);

        if (3 == curPos)
            return isTrue(array) ? 1 : 0;

        if (nums.length == index)
            return 0;

        int sum = 0;

        for (int i = index; i < nums.length - (2 - curPos); i++) {
            array[curPos] = nums[i];
            sum += process(nums, i + 1, curPos + 1, array, map);
        }

        map.put(code, sum);
        return sum;
    }

    private String getHashCode(int curPos, int[] array) {
        String s = curPos + "_";
        for (int i = 0; i < array.length; i++) {
            s = s + "_" + array[i];
        }
        return s;
    }

    private boolean isTrue(int[] array) {
        if (array[0] + array[1] <= array[2])
            return false;
        if (array[0] + array[2] <= array[1])
            return false;
        if (array[1] + array[2] <= array[0])
            return false;
        return true;
    }
}