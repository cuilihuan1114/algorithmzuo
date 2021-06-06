
import java.util.ArrayList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/6/1 10:49
 */
public class Problem_0986_区间列表的交集 {

    public static void main(String[] args) {
        System.out.println(new Problem_0986_区间列表的交集().intervalIntersection(new int[][]{{1, 3}, {5, 9}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}}));
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null || secondList == null)
            return new int[][]{};


        List<int[]> list = new ArrayList<>();
        for (int i = 0, j = 0; i < firstList.length && j < secondList.length; ) {
            int[] first = firstList[i];
            int[] second = secondList[j];

            int min = Math.max(first[0], second[0]);
            int max = Math.min(first[1], second[1]);
            if (min <= max)
                list.add(new int[]{min, max});


            if (max == first[1])
                i++;
            else
                j++;
        }

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;

    }
}
