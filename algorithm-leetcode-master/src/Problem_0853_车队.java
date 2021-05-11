
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author cuilihuan
 * @data 2021/5/11 15:49
 */
public class Problem_0853_车队 {

    public static void main(String[] args) {
        System.out.println(new Problem_0853_车队().carFleet(12,
                new int[]{10, 8, 0, 5, 3},
                new int[]{2, 4, 1, 1, 3}));
    }

    public int carFleet(int target, int[] position, int[] speed) {

        if(position == null || position.length == 0)
            return 0;

        List<Info> list = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            list.add(new Info(target - position[i], (double) (target - position[i]) / speed[i]));
        }

        Collections.sort(list, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.pos - o2.pos;
            }
        });

        int ans = 0;
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).time > list.get(i-1).time)
                ans++;
            else
                list.get(i).time = list.get(i-1).time;
        }

        return ans + 1;

    }

    class Info{
        int pos;
        double time;

        public Info(int pos, double time) {
            this.pos = pos;
            this.time = time;
        }
    }
}
