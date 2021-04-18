import java.util.LinkedList;
import java.util.List;

/**
     * @author cuilihuan
     * @data 2021/4/8 16:05
     */
    public  class Problem_0686_重复叠加字符串匹配 {


        public static void main(String[] args) {
            System.out.println(new Problem_0686_重复叠加字符串匹配().repeatedStringMatch("abcd", "cdabcdab"));
        }

        public int repeatedStringMatch(String a, String b) {
            int[] countA = new int[26];
            for (int i = 0; i < a.length(); i++) {
                countA[a.charAt(i) - 'a']++;
            }
            int[] countB = new int[26];
            for (int i = 0; i < b.length(); i++) {
                countB[b.charAt(i) - 'a']++;
            }

            char target = b.charAt(0);
            List<Integer> pos = new LinkedList<>();
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == target)
                    pos.add(i);
            }

            int res = 0;
            for (int i = 0; i < pos.size(); i++) {
                int p = isSubString(a, b, pos.get(i));
                if (p > -1) {
                    return p;
                }
            }

            return -1;
        }

        private int isSubString(String a, String b, int pos) {
            int nums = 1;
            int leftA = pos;
            for (int i = 0; i < b.length(); i++) {
                if (a.charAt(leftA) == b.charAt(i)) {
                    leftA++;
                    if (leftA == a.length()) {
                        leftA = 0;
                        if(i != b.length() - 1)
                            nums++;
                    }
                } else {
                    return -1;
                }
            }
            return nums;
        }
    }