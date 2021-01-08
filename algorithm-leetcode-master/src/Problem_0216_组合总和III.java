import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by CUI on 2021/1/8
 */
public class Problem_0216_组合总和III {

    public static void main(String[] args) {
        System.out.println(new Problem_0216_组合总和III().combinationSum3(3, 9).size());
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> record = new ArrayList<>();
        if (k == 0 || n == 0)
            return record;
        LinkedList<Integer> list = new LinkedList<>();
        process(k, n, 0, list, record, 0, 1);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//
//        }
        return record;

    }

    private void process(int length, int sum, int index, LinkedList<Integer> list, List<List<Integer>> record, int cur, int start) {
        if (index == length) {
            if (sum == cur) {
                List<Integer> ans = new ArrayList<>(list);
                record.add(ans);
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            int all = cur + i;
            if(all > sum)
                return;
            list.add(i);
            process(length, sum, index + 1, list, record, all, i + 1);
            list.removeLast();
        }
    }


}
