/**
 * Created by CUI on 2021/1/11
 */
public class Problem_0278_第一个错误的版本 {
    // 如果写成 (left + right) / 2 会超时时间限制 2126753390 1702766719
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            // 改成int mid = left + ((right - left) >> 1); 不会超时
            //或者  int mid = left + (right - left)  / 2;
            int mid = (left + right) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int n) {
        return true;
    }
}
