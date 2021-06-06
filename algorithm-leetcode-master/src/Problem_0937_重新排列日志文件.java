
import java.util.*;

/**
 * @author cuilihuan
 * @data 2021/5/28 20:34
 */
public class Problem_0937_重新排列日志文件 {
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0)
            return logs;

        List<String> letterLog = new ArrayList<>();
        List<String> digitLOg = new ArrayList<>();


        for (int i = 0; i < logs.length; i++) {
            char c = logs[i].charAt(logs[i].length() - 1);
            if (c >= 'a' && c <= 'z')
                letterLog.add(logs[i]);
            else
                digitLOg.add(logs[i]);
        }

        Collections.sort(letterLog, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int index1 = o1.split(" ")[0].length();
                int index2 = o2.split(" ")[0].length();
                int comp = o1.substring(index1).compareTo(o2.substring(index2));
                if (comp == 0)
                    return o1.substring(0, index1).compareTo(o2.substring(0, index2));
                return comp;
            }
        });

        String[] res = new String[logs.length];
        int i = 0;
        for (; i < letterLog.size(); i++) {
            res[i] = letterLog.get(i);
        }
        for (int j = 0; j < digitLOg.size(); j++) {
            res[i++] = digitLOg.get(j);
        }

        return res;
    }
}
