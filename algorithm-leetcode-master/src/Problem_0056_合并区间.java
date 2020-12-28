import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2020/12/5 14:45
 */
public class Problem_0056_合并区间 {
    public static void main(String[] args) {
        System.out.println(new Problem_0056_合并区间().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
    }
    class Info{
        int start;
        int end;

        public Info(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Info() {
        }
    }

    class MyComparator implements Comparator<Info>{
        @Override
        public int compare(Info o1, Info o2) {
            return o1.start - o2.start;
        }
    }

    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return new int[0][0];
        List<Info> list = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Info(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(list,new MyComparator());

        List<Info> newList = new LinkedList<>();
        int start = list.get(0).start;
        int end = list.get(0).end;
        for (int i = 1; i < list.size(); i++) {
            if(end < list.get(i).start){
                newList.add(new Info(start, end));
                start = list.get(i).start;
                end = list.get(i).end;
            }else {
                end = Math.max(list.get(i).end, end);
            }
        }
        newList.add(new Info(start, end));
        int[][] reInts = new int[newList.size()][2];
        for (int i = 0; i < reInts.length; i++) {
            reInts[i][0] = newList.get(i).start;
            reInts[i][1] = newList.get(i).end;
        }
        return reInts;
    }
}
