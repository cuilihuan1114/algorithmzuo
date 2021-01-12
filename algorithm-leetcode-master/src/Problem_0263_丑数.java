/**
 * Created by CUI on 2021/1/11
 */
public class Problem_0263_丑数 {
    public boolean isUgly(int num) {
        while (num != 1){
            if(num % 3 == 0)
                num = num / 3;
            else if(num % 5 == 0 )
                num = num / 5;
            else if(num % 2 == 0)
                num = num / 2;
            else
                return false;
        }
        return true;
    }
}
