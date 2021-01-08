import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by CUI on 2021/1/6
 */
public class Problem_0166_分数到小数 {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return "0";

        HashMap<Long, Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        int flag = (numerator < 0 ? 0 : 1) ^ (denominator < 0 ? 0 : 1);
        if(flag == 1)
            builder.append("-");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        builder.append(num / den);
        long res = num % den;
        if (res == 0) {
            return builder.toString();
        }
        builder.append(".");
        map.put(res, builder.length());
        while (res != 0) {
            res *= 10;
            builder.append(res / den);
            res = res % den;
            if (map.containsKey(res)) {
                Integer pos = map.get(res);
                builder.insert(pos, "(");
                builder.append(')');
                break;
            }else
                map.put(res, builder.length());
        }
        return builder.toString();
    }
}
