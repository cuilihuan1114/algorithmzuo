import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/3/8 22:08
 */
public class Problem_0412_Fizz_Buzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            if(i % 3 == 0 && i % 5 == 0){
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            }else
                list.add(i + "");
        }
        return list;
    }
}
