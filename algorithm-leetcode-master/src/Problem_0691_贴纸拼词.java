
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author cuilihuan
 * @data 2021/3/26 14:37
 */
public class Problem_0691_贴纸拼词 {

    public static void main(String[] args) {
        System.out.println(new Problem_0691_贴纸拼词().minStickers4(new String[]{"with", "example", "science"}, "thehat"));
    }


    public static int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        int[][] map = new int[n][26];
        for (int i = 0; i < n; i++) {
            char[] str = stickers[i].toCharArray();
            for (char c : str) {
                map[i][c - 'a']++;
            }
        }
        char[] str = target.toCharArray();
        int[] tmap = new int[26];
        for (char c : str) {
            tmap[c - 'a']++;
        }
        HashMap<String, Integer> dp = new HashMap<>();
        int ans = process2(map, 0, tmap, dp);
        return ans;
    }

    public static int process2(int[][] map, int i, int[] tmap, HashMap<String, Integer> dp) {
        StringBuilder keyBuilder = new StringBuilder();
        keyBuilder.append(i + "_");
        for (int asc = 0; asc < 26; asc++) {
            if (tmap[asc] != 0) {
                keyBuilder.append((char) (asc + 'a') + "_" + tmap[asc] + "_");
            }
        }
        String key = keyBuilder.toString();
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        boolean finish = true;
        for (int asc = 0; asc < 26; asc++) {
            if (tmap[asc] != 0) {
                finish = false;
                break;
            }
        }
        if (finish) {
            dp.put(key, 0);
            return 0;
        }
        if (i == map.length) {
            dp.put(key, -1);
            return -1;
        }
        int maxZhang = 0;
        for (int asc = 0; asc < 26; asc++) {
            if (map[i][asc] != 0 && tmap[asc] != 0) {
                maxZhang = Math.max(maxZhang, (tmap[asc] / map[i][asc]) + (tmap[asc] % map[i][asc] == 0 ? 0 : 1));
            }
        }
        int[] backup = Arrays.copyOf(tmap, tmap.length);
        int min = Integer.MAX_VALUE;
        int next = process2(map, i + 1, tmap, dp);
        tmap = Arrays.copyOf(backup, backup.length);
        if (next != -1) {
            min = next;
        }
        for (int zhang = 1; zhang <= maxZhang; zhang++) {
            for (int asc = 0; asc < 26; asc++) {
                tmap[asc] = Math.max(0, tmap[asc] - (map[i][asc] * zhang));
            }
            next = process2(map, i + 1, tmap, dp);
            tmap = Arrays.copyOf(backup, backup.length);
            if (next != -1) {
                min = Math.min(min, zhang + next);
            }
        }
        int ans = min == Integer.MAX_VALUE ? -1 : min;
        dp.put(key, ans);
        return ans;
    }

    public static int minStickers1(String[] stickers, String target) {

        int n = stickers.length;

        int[][] map = new int[n][26];// stickers -> [26] [26] [26]
        for (int i = 0; i < n; i++) {
            char[] str = stickers[i].toCharArray();
            for (char c : str) {
                map[i][c - 'a']++;
            }
        }
        HashMap<String, Integer> dp = new HashMap<>();
        dp.put("", 0);
        return process1(dp, map, target);
    }

    // dp 傻缓存，如果t已经算过了，直接返回dp中的值
    // t 剩余的目标
    // 0..N每一个字符串所含字符的词频统计
    // 返回值是-1，map 中的贴纸  怎么都无法rest
    public static int process1(
            HashMap<String, Integer> dp,
            int[][] map,
            String rest) {
        if (dp.containsKey(rest)) {
            return dp.get(rest);
        }
        // 以下就是正式的递归调用过程
        int ans = Integer.MAX_VALUE; // ans -> 搞定rest，使用的最少的贴纸数量
        int n = map.length; // N种贴纸
        int[] tmap = new int[26]; // tmap 去替代 rest
        char[] target = rest.toCharArray();
        for (char c : target) {
            tmap[c - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            // 枚举当前第一张贴纸是谁？
            if (map[i][target[0] - 'a'] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            // i 贴纸， j 枚举a~z字符
            for (int j = 0; j < 26; j++) { //
                if (tmap[j] > 0) { // j这个字符是target需要的
                    for (int k = 0; k < Math.max(0, tmap[j] - map[i][j]); k++) {
                        sb.append((char) ('a' + j));
                    }
                }
            }
            // sb ->  i
            String s = sb.toString();
            int tmp = process1(dp, map, s);
            if (tmp != -1) {
                ans = Math.min(ans, 1 + tmp);
            }
        }
        // ans 系统最大  rest
        dp.put(rest, ans == Integer.MAX_VALUE ? -1 : ans);
        return dp.get(rest);
    }

    public int minStickers4(String[] stickers, String target) {
        int[] ans = new int[26];
        int all = 0;
        for (int i = 0; i < target.length(); i++) {
            ans[target.charAt(i) - 'a']++;
            all++;
        }

        int n = stickers.length;

        int[][] map = new int[n][26];// stickers -> [26] [26] [26]
        for (int i = 0; i < n; i++) {
            char[] str = stickers[i].toCharArray();
            for (char c : str) {
                map[i][c - 'a']++;
            }
        }


        HashMap<String, Integer> curmap = new HashMap<>();
        int p1 = process1(map, ans, all, curmap);
        return p1 == Integer.MAX_VALUE ? -1 : p1;
    }

    private int process1(int[][] stickers, int[] ans, int all, HashMap<String, Integer> map) {
        if (all == 0)
            return 0;

        String code = getHashCode(ans);
        if (map.containsKey(code))
            return map.get(code);

        int pre = all;
        int max = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] > 0) {
                index = i;
                break;
            }
        }

        for (int i = 0; i < stickers.length; i++) {
            int[] s = stickers[i];

            if (s[index] == 0)
                continue;

            boolean flag = false;
            int[] cur = getCopyArray(ans);
            pre = all;
            for (int j = 0; j < s.length; j++) {
                if (s[j] > 0 && cur[j] > 0) {
                    flag = true;
                    if (cur[j] >= s[j]) {
                        pre = pre - (s[j]);
                        cur[j] = cur[j] - s[j];
                    } else {
                        pre = pre - cur[j];
                        cur[j] = 0;
                    }
                    //                    pre = pre - Math.min(cur[j],cur[j] - s[j]);
                }
            }
            if (flag) {
                max = Math.min(max, process1(stickers, cur, pre, map));
            }
        }
        int p1 = max == Integer.MAX_VALUE ? Integer.MAX_VALUE : max + 1;
        map.put(code, p1);
        return p1;
    }

    private String getHashCode(int[] ans) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i] + "-");
        }
        return sb.toString();
    }

    private int[] getCopyArray(int[] ans) {
        int[] res = new int[ans.length];
        for (int i = 0; i < ans.length; i++) {
            res[i] = ans[i];
        }
        return res;
    }


    public int minStickers3(String[] stickers, String target) {
        int[] ans = new int[26];
        int all = 0;
        for (int i = 0; i < target.length(); i++) {
            ans[target.charAt(i) - 'a']++;
            all++;
        }

        int p1 = process(stickers, ans, all);
        return p1 == Integer.MAX_VALUE ? -1 : p1;
    }

    private int process(String[] stickers, int[] ans, int all) {
        if (all == 0)
            return 0;

        int pre = all;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < stickers.length; i++) {
            String s = stickers[i];
            boolean flag = false;
            int[] cur = getCopyArray(ans);
            pre = all;
            for (int j = 0; j < s.length(); j++) {
                if (cur[s.charAt(j) - 'a'] > 0) {
                    flag = true;
                    cur[s.charAt(j) - 'a']--;
                    pre--;
                }
            }
            if (flag) {
                max = Math.min(max, process(stickers, cur, pre));
            }
        }
        return max == Integer.MAX_VALUE ? Integer.MAX_VALUE : max + 1;
    }

}
