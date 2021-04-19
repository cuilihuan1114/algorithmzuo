package D0415;

import java.util.*;

/**
 * @author cuilihuan
 * @data 2021/4/9 17:48
 */
public class Main {

    static class Info {
        int start;
        int end;

        public Info(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] split = input.next().split(",");
        List<Info> list = new LinkedList<>();
        for (int i = 0; i < split.length; i++) {
            String cur = split[i];
            String[] split1 = cur.split("-");
            list.add(new Info(Integer.parseInt(split1[0]), Integer.parseInt(split1[1])));
        }

        Collections.sort(list, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.start - o2.start == 0 ? o2.end - o1.end : o1.start - o2.start;
            }
        });

        Info first = list.get(0);
        int start = first.start;
        int end = first.end;
        for (int i = 1; i < list.size(); i++) {
            Info cur = list.get(i);
            if (cur.start > end + 1) {
                System.out.print(start + "-" + end + ",");
                start = cur.start;
                end = cur.end;
            } else {
                if (cur.start == end + 1)
                    end = end + 1;
                if (cur.end >= end + 1) {
                    end = cur.end;
                }
            }
        }

        System.out.println(start + "-" + end);
    }
}
