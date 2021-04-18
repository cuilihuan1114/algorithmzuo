import java.util.HashSet;

/**
     * @author cuilihuan
     * @data 2021/3/19 9:45
     */
    public  class Problem_0467_环绕字符串中唯一的子字符串 {

        public static void main(String[] args) {
            System.out.println(new Problem_0467_环绕字符串中唯一的子字符串().findSubstringInWraproundString("vwxyefghijklmnopqrsomnopqrstuvefghijklmklmnopqrsqrstefghijklmnopqpqrstuvwxyzidefghijbcefghijklmnopqrstuvwghijklmnopqrstuvwhijklmnopbcdefghijklmnopopqrstuvwxyzstuvwxyfghijklmnopqrstuvwxyzmnopqrstuvwxyzhijklmnopfghijklfghijklmnopfghijklmnopqrsttuvwxabcdefghijklmnjklmnopqrstuvwxijklmnopabcdefghijklmnopqopqrstuvfghijklmnopqrstuvefghijkklmnopqrstuvabcdefghijklmnopqabcdefklmnopqefghijklmnopqrmbcdefghmnopqrstulnopqrstklmnopqrstuvwstuvnopqrstuvwxytuvwxhijklmnopqrstuvwxyzijklmnopqrstuabcdefghipqrstulabcdefghijklmnopijklmnopqrsabcdefgcdefghijklmnopqfghijklmnopqrfghijklmnohijklmnopqrstuvwxyzabcdhijklmnopqrstuvghijkrstuvwxyzabcdefghijklmnopqrcdefghijklmfghijklmnopqrstuvghijlmnopopqrstuvwxyjklmndefghijklmnopqrstuvwjklmghijklmnopqrstuvwxyfghijklmdefghijklmnopqrstuvwxfghijklmnopqrshijklmnopqcdefghiabcdefghijklmnopqrsttuvwuvwxyzhijklmnofghijkllmnopqrstuvwxnopqrhijklmnopqrstuvwxyzjklmnopqrstuvwxefghiefghijklmnopqrtuvwxpqrstuvklmnabcdefghijklmnopklefghijklmnopqrstuvjklmnopqrsbcdefghijkcdefghijklmfghijklmnopqrstuv"));
        }

        public int findSubstringInWraproundString(String p) {
            if (p == null || p.length() == 0)
                return 0;

            int[] count = new int[26];
            int maxLen = 0;
            for (int i = 0; i < p.length(); i++) {
                if(i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i)- p.charAt(i-1) == ('a' - 'z')))
                    maxLen++;
                else
                    maxLen = 1;
                count[p.charAt(i) - 'a'] = Math.max(count[p.charAt(i) - 'a'], maxLen);
            }

            int sum = 0;
            for (int i = 0; i < count.length; i++) {
                sum += count[i];
            }
            return sum;
        }

            // 超时了
        public int findSubstringInWraproundString1(String p) {
            if (p == null || p.length() == 0)
                return 0;

            int[][] cache = new int[p.length()][p.length()];
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < cache.length; i++) {
                cache[i][i] = 1;
                set.add(getHashCode(i - i, p.charAt(i), p.charAt(i)));
    //            set.add(p.substring(i, i + 1));
            }


            for (int i = 0; i < cache.length; i++) {
                for (int j = i + 1; j < cache.length; j++) {
                    if (p.charAt(j) == 'a') {
                        cache[i][j] = ((cache[i][j - 1] == 1 && p.charAt(j - 1) == 'z') ? 1 : 0);
                    } else {
                        cache[i][j] = (cache[i][j - 1] == 1 && p.charAt(j) - p.charAt(j - 1) == 1) ? 1 : 0;
                    }

                    if (cache[i][j] == 1) {
    //                    set.add(p.substring(i, j + 1));
                        set.add(getHashCode(j - i, p.charAt(i), p.charAt(j)));
                    }
                }
            }


            return set.size();
        }

        private String getHashCode(int i, char first, char second) {
            return i + "_" + first + "_" + second;
        }


    }