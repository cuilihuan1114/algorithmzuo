
import java.util.Arrays;

/**
 * @author cuilihuan
 * @data 2021/5/23 19:33
 */
public class Problem_0870_优势洗牌 {

    public static void main(String[] args) {
        int[] count = new Problem_0870_优势洗牌().advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11});
        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        boolean[] flag = new boolean[nums1.length];
        int[] ans = new int[nums1.length];
        if( nums1.length == 0)
            return ans;
        Arrays.sort(nums1);



        int start = 0;
        int end = nums1.length - 1;
        int index = 0;

        int first = 0;

        for (int i = 0; i < nums2.length; i++) {
            // 采用二分法来寻找每个仅比它大的数的值
            int pos = getMiddle(nums1, start, end, nums2[i]);
            while (pos != -1 && pos < nums1.length) {
                if (!flag[pos]) {
                    ans[index++] = nums1[pos];
                    flag[pos] = true;
                    break;
                }
                pos++;
            }

            // 如果没有找到 则会从头开始为其找一个最小的值
            if(pos == -1 || pos == nums1.length) {
                while (true) {
                    if (!flag[first]) {
                        ans[index++] = nums1[first];
                        flag[first] = true;
                        first++;
                        break;
                    }
                    first++;
                }
            }

            while (true){
                if(first < nums1.length - 1 && flag[first])
                    first++;
                else
                    break;
            }
        }
        return ans;
    }

    // 二分法寻找某个第一个比它大的数
    private int getMiddle(int[] nums1, int start, int end, int target) {
        while (start <= end) {
            int middle = (start + end) / 2;
            if (nums1[middle] <= target) {
                start = middle + 1;
            } else
                end = middle - 1;
        }
        return (end == -1 || start == nums1.length) ? -1 : start;
    }
}
