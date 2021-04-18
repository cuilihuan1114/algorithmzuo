import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/3/5 10:11
 */
public class Problem_0386_字典序排数 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        process(n, list, 0, sum);
        return list;
    }

    private void process(int n, List<Integer> list, int index, int sum) {
        if(sum > n)
            return;
        if(sum != 0)
            list.add(sum);

        if(index != 0){
            process(n, list, index + 1, sum * 10);
        }
        for (int i = 1; i <= 9 ; i++) {
            process(n, list, index + 1, sum * 10 + i);
        }
    }
}
