/**
 * @author cuilihuan
 * @data 2021/3/5 10:01
 */
public class Problem_0367_有效的完全平方数 {

    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num / 2 + 1;
        while (left <= right){
            long middle = left + (right - left) / 2;
            if(middle * middle == num)
                return true;
            else if(middle * middle > num){
                right = middle - 1;
            }else
                left = middle + 1;
        }
        return false;
    }

    public boolean isPerfectSquare1(int num) {
        for (int i = 1; i <= num ; i++) {
            if(i * i == num)
                return true;
            else if(i * i > num)
                return false;
        }
        return false;
    }
}
