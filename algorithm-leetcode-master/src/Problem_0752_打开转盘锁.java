import java.util.HashSet;
import java.util.Set;

/**
 * @author cuilihuan
 * @data 2021/4/13 9:39
 */
public class Problem_0752_打开转盘锁 {

    public static void main(String[] args) {
        System.out.println(new Problem_0752_打开转盘锁().openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));
    }


    public int openLock(String[] deadends, String target) {
        HashSet<String> deadendSet = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) {
            deadendSet.add(deadends[i]);
        }

        String start = "0000";
        if (start.equals(target))
            return 0;
        if (deadendSet.contains(start))
            return -1;
        Set<String> preList = new HashSet<>();
        preList.add(start);

        HashSet<String> exists = new HashSet<>();
        return process(preList, deadendSet, exists, target);
    }

    private int process(Set<String> preList, HashSet<String> deadendSet, HashSet<String> exists, String target) {

        int count = 0;
        while (preList.size() != 0) {
            exists.addAll(preList);
            Set<String> cur = new HashSet<>();
            count++;

            for (String s : preList) {
                char[] array = s.toCharArray();
                for (int i = 0; i < array.length; i++) {
                    char pre = array[i];
                    boolean flag = false;
                    if (array[i] == '0') {
                        array[i] = '9';
                        flag = true;
                    } else if (array[i] >= '1' && array[i] <= '9') {
                        flag = true;
                        array[i] = (char) (array[i] - 1);
                    }
                    String res = "";
                    if (flag) {
                        res = String.valueOf(array);
                        if (target.equals(res))
                            return count;
                        if (!deadendSet.contains(res) && !exists.contains(res)) {
                            cur.add(res);
                        }
                    }

                    array[i] = pre;
                    flag = false;
                    if (array[i] == '9') {
                        array[i] = '0';
                        flag = true;
                    } else if (array[i] >= '0' && array[i] <= '8') {
                        array[i] = (char) (array[i] + 1);
                        flag = true;
                    }
                    if (flag) {
                        res = String.valueOf(array);
                        if (target.equals(res))
                            return count;
                        if (!deadendSet.contains(res) && !exists.contains(res)) {
                            cur.add(res);
                        }
                        array[i] = pre;
                    }
                }
            }
            preList = cur;
        }
        return -1;
    }
}