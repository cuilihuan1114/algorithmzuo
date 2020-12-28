/**
 * @author cuilihuan
 * @data 2020/12/18 10:23
 */
public class Problem_0088_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int position = nums1.length - 1;
        m = m- 1;
        n = n -1;
        while (m >= 0 && n >= 0) {
            nums1[position--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n >= 0)
            nums1[position--] = nums2[n--];
    }
}
