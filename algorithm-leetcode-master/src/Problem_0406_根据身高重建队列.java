import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by CUI on 2021/2/27
 */
public class Problem_0406_根据身高重建队列 {

    class People{
        int height;
        int nums;

        public People(int height, int nums) {
            this.height = height;
            this.nums = nums;
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        List<People> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(new People(people[i][0], people[i][1]));
        }
        Collections.sort(list, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o2.height != o1.height ? o2.height - o1.height : o1.nums - o2.nums;
            }
        });

        List<People> afterList = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            afterList.add(list.get(i).nums,list.get(i));
        }

        int[][] afterPeople = new int[people.length][2];
        for (int i = 0; i < afterPeople.length; i++) {
            afterPeople[i][0] = afterList.get(i).height;
            afterPeople[i][1] = afterList.get(i).nums;
        }

        return afterPeople;
    }
}
