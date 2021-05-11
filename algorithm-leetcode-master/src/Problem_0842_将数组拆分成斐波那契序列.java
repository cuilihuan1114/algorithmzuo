
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/5/9 18:26
 */
public class Problem_0842_将数组拆分成斐波那契序列 {

    public static void main(String[] args) {
        System.out.println(new Problem_0842_将数组拆分成斐波那契序列().splitIntoFibonacci("123456579"));
    }


    public List<Integer> splitIntoFibonacci(String S) {
        LinkedList<Integer> list = new LinkedList<>();
        if (S == null || S.length() == 0)
            return list;

        int first = 0;
        int second = 0;
        for (int i = 0; i < S.length(); i++) {
            if (first == 0 && i != 0 )
                return list;
            first = first * 10 + (S.charAt(i) - '0');
            if(first < 0)
                return list;
            list.add(first);
            second = 0;
            for (int j = i + 1; j < S.length() - 1; j++) {
                if (second == 0 && j != i + 1)
                    continue;

                second = second * 10 + (S.charAt(j) - '0');
                if(second < 0)
                    continue;
                list.add(second);
                if (process(S, j + 1, first, second, list))
                    return list;
                list.removeLast();
            }
            list.removeLast();
        }
        return list;
    }

    private boolean process(String S, int index, int first, int second, LinkedList<Integer> list) {

        if (index == S.length())
            return true;

        int third = 0;
        for (int i = index; i < S.length(); i++) {
            if (third == 0 && i != index)
                return false;
            third = third * 10 + S.charAt(i) - '0';
            if(third < 0)
                return false;


            if (third == first + second) {
                list.addLast(third);
                boolean flag = process(S, i + 1, second, third, list);
                if (flag) {
                    return true;
                }
                list.removeLast();
                return false;
            }
        }
        return false;
    }


}
