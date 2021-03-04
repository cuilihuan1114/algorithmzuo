/**
 * Created by CUI on 2021/3/2
 */
public class Problem_0374_猜数字大小 {

    public int guess(int num) {
        return 0;
    }
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0)
                return mid;
            else if (res < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public int guessNumber1(int n) {
        int left = 1;
        int right = n;

        while (left<=right) {
            // 这样会超过最大范围Int
            int middle = (left + right) / 2;
            int res = guess(middle);
            if(res == 0)
                return middle;
            else if(res == -1){
                right = middle - 1;
            }else
                left = middle+1;

        }

        return  -1;
    }

    public int guessNumber2(int n) {
        long left = 1;
        long right = n;

        while (left<=right) {
            // 这样会超过最大范围Int
            long middle = (left + right) / 2;
            long res = guess((int)(middle));
            if(res == 0)
                return (int)(middle);
            else if(res == -1){
                right = middle - 1;
            }else
                left = middle+1;

        }

        return  -1;
    }
}
