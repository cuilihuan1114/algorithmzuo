import java.util.Arrays;

/**
     * @author cuilihuan
     * @data 2021/4/11 18:47
     */
    public  class Problem_0720_词典中最长的单词 {
        class Tire{
            Tire[] next = new Tire[26];
        }
        public String longestWord(String[] words) {
            if(words == null || words.length == 0)
                return "";

            Arrays.sort(words);

            Tire root = new Tire();
            int max = 0;
            String maxStr = "";
            for (int i = 0; i < words.length; i++) {
                String str = words[i];
                Tire cur = root;
                boolean flag = false;
                for (int j = 0; j < str.length() - 1; j++) {
                    int c = str.charAt(j) - 'a';
                    if(cur.next[c] == null) {
                        flag = true;
                        break;
                    }
                    cur = cur.next[c];
                }
                if(flag)
                    continue;
                int last = str.charAt(str.length() - 1) - 'a';
                if(cur.next[last] == null)
                    cur.next[last] = new Tire();
                if(str.length() > max){
                    max = str.length();
                    maxStr = str;
                }
            }
            return maxStr;
        }
    }