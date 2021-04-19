package pso;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author cuilihuan
 * @data 2021/3/26 19:37
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hotels = scanner.nextInt();
        int[][] dis = new int[hotels + 1][hotels + 1];
        for (int i = 0; i < hotels - 1; i++) {
            int one = scanner.nextInt();
            int other = scanner.nextInt();
            dis[one][other] = scanner.nextInt();
        }

        List<List<Integer>> love = new ArrayList();
        List<Integer> cur = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        process(dis, love, ans, 0,cur);
    }

    private static void process(int[][] dis, List<List<Integer>> love, List<Integer> ans, int index, List<Integer> cur) {
        if(index == love.size()){
//            ans.add(compulte(dis,cur));
            return;
        }

        List<Integer> list = love.get(index);
        for (int i = 0; i < list.size(); i++) {
            cur.add(list.get(i));
            process(dis, love, ans, index + 1, cur);
            cur.remove(list.size() - 1);
        }
    }


}
