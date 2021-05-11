
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cuilihuan
 * @data 2021/5/9 16:34
 */
public class Problem_0841_钥匙和房间 {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(2);
        first.add(3);
        list.add(first);
        list.add(new ArrayList<>());

        List<Integer> second = new ArrayList<>();
        second.add(2);
        list.add(second);

        List<Integer> three = new ArrayList<>();
        three.add(1);
        three.add(3);
        three.add(1);
        list.add(three);

        System.out.println(new Problem_0841_钥匙和房间().canVisitAllRooms(list));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0)
            return false;
        int cur = 0;
        Set<Integer> set = new HashSet<>();
        set.add(cur);
        return process(rooms, cur, set);
    }

    private boolean process(List<List<Integer>> rooms, int cur, Set<Integer> set) {

        if(set.size() == rooms.size())
            return true;

        boolean flag = false;
        List<Integer> list = rooms.get(cur);
        for(Integer key : list){
            if(set.contains(key))
                continue;
            set.add(key);
            flag = process(rooms, key, set);
            if(flag)
                return true;
        }

        return false;
    }
}
