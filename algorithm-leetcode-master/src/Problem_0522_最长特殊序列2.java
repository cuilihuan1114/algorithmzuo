import java.util.Arrays;
import java.util.Comparator;

/**
     * @author cuilihuan
     * @data 2021/3/20 19:01
     */
    public  class Problem_0522_最长特殊序列2 {


        public static void main(String[] args) {
            System.out.println(new Problem_0522_最长特殊序列2().findLUSlength(new String[]{"a","b","c","d","e","f","a","b","c","d","e","f"}));

        }

        public boolean isSubsequence(String x, String y) {
            int j = 0;
            for (int i = 0; i < y.length() && j < x.length(); i++)
                if (x.charAt(j) == y.charAt(i))
                    j++;
            return j == x.length();
        }

        public int findLUSlength(String[] strs) {
            Arrays.sort(strs, new Comparator< String >() {
                public int compare(String s1, String s2) {
                    return s2.length() - s1.length();
                }
            });

            for (int i = 0, j; i < strs.length; i++) {
                boolean flag = true;
                for (j = 0; j < strs.length; j++) {
                    if (i == j)
                        continue;
                    if (isSubsequence(strs[i], strs[j])) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    return strs[i].length();
            }
            return -1;
        }

    }
