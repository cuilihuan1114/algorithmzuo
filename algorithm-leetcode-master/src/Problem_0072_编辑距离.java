import java.util.Arrays;

/**
 * @author cuilihuan
 * @data 2020/12/5 15:23
 */
public class Problem_0072_编辑距离 {

    public static void main(String[] args) {
        System.out.println(new Problem_0072_编辑距离().minDistance("horse", "ros"));
    }

    //方法四
    public int minDistance(String word1, String word2) {
        int[][] cache = new int[word1.length() + 1][word2.length() + 1];
        //word1 word2
        cache[word1.length()][word2.length()] = 0;

        for (int i = word2.length() - 1; i >= 0; i--) {
            cache[word1.length()][i] = cache[word1.length()][i + 1] + 1;
        }

        for (int i = word1.length() - 1; i >= 0; i--) {
            cache[i][word2.length()] = cache[i + 1][word2.length()] + 1;
        }

        int pMax = Integer.MAX_VALUE;
        for (int i = word1.length() - 1; i >= 0; i--) {
            for (int j = word2.length() - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j))
                    pMax = cache[i + 1][j + 1];
                else
                    //替换
                    pMax = cache[i + 1][j + 1] + 1;
                //插入
                pMax = Math.min(pMax, cache[i][j + 1] + 1);
                //删除
                pMax = Math.min(pMax, cache[i + 1][j] + 1);
                cache[i][j] = pMax;
            }
        }
        return cache[0][0];
    }


    //方法三
    public int minDistance4(String word1, String word2) {
        int[][] cache = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return process3(word1, word2, 0, 0, cache);
    }

    private int process3(String word1, String word2, int index1, int index2, int[][] cache) {
        if (cache[index1][index2] >= 0)
            return cache[index1][index2];
        if (index1 == word1.length() && index2 == word2.length()) {
            cache[index1][index2] = 0;
            return 0;
        }
        if (index1 == word1.length()) {
            cache[index1][index2] = process3(word1, word2, index1, index2 + 1, cache) + 1;
            return cache[index1][index2];
        }
        if (index2 == word2.length()) {
            cache[index1][index2] = process3(word1, word2, index1 + 1, index2, cache) + 1;
            return cache[index1][index2];
        }
        int pMax = Integer.MAX_VALUE;
        if (word1.charAt(index1) == word2.charAt(index2))
            pMax = process3(word1, word2, index1 + 1, index2 + 1, cache);
        else
            //替换
            pMax = process3(word1, word2, index1 + 1, index2 + 1, cache) + 1;
        //插入
        pMax = Math.min(pMax, process3(word1, word2, index1, index2 + 1, cache) + 1);
        //删除
        pMax = Math.min(pMax, process3(word1, word2, index1 + 1, index2, cache) + 1);
        cache[index1][index2] = pMax;
        return pMax;
    }


    //这种方式是错误的
    //下面是三个变量 而你的cache只用了两个 所以肯定会错的
    //其实在这里向下加 会把当前的值向下去的 所以会出现问题 所以有了如上的方法 在当前方法加
    public int minDistance3(String word1, String word2) {
        int[][] cache = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return process1(word1, word2, 0, 0, 0, cache);
    }

    private int process1(String word1, String word2, int index1, int index2, int step, int[][] cache) {

        if (cache[index1][index2] >= 0)
            return cache[index1][index2];

        if (index1 == word1.length() && index2 == word2.length()) {
            cache[index1][index2] = step;
            return step;
        }

        if (index1 == word1.length()) {
            cache[index1][index2] = process1(word1, word2, index1, index2 + 1, step + 1, cache);
            return cache[index1][index2];
        }

        if (index2 == word2.length()) {
            cache[index1][index2] = process1(word1, word2, index1 + 1, index2, step + 1, cache);
            return cache[index1][index2];
        }
        int pMax = Integer.MAX_VALUE;
        if (word1.charAt(index1) == word2.charAt(index2))
            pMax = process1(word1, word2, index1 + 1, index2 + 1, step, cache);
        else
            //替换
            pMax = process1(word1, word2, index1 + 1, index2 + 1, step + 1, cache);
        //插入
        pMax = Math.min(pMax, process1(word1, word2, index1, index2 + 1, step + 1, cache));
        //删除
        pMax = Math.min(pMax, process1(word1, word2, index1 + 1, index2, step + 1, cache));
        cache[index1][index2] = pMax;
        return pMax;
    }

    //方法二
    public int minDistance2(String word1, String word2) {
        return process2(word1, word2, 0, 0);
    }

    private int process2(String word1, String word2, int index1, int index2) {
        if (index1 == word1.length() && index2 == word2.length())
            return 0;
        if (index1 == word1.length())
            return process2(word1, word2, index1, index2 + 1) + 1;
        if (index2 == word2.length())
            return process2(word1, word2, index1 + 1, index2) + 1;

        int pMax = Integer.MAX_VALUE;
        if (word1.charAt(index1) == word2.charAt(index2))
            pMax = process2(word1, word2, index1 + 1, index2 + 1);
        else
            //替换
            pMax = process2(word1, word2, index1 + 1, index2 + 1) + 1;
        //插入
        pMax = Math.min(pMax, process2(word1, word2, index1, index2 + 1) + 1);
        //删除
        pMax = Math.min(pMax, process2(word1, word2, index1 + 1, index2) + 1);
        return pMax;
    }

    //递归超时
    public int minDistance1(String word1, String word2) {
        return process(word1, word2, 0, 0, 0);
    }

    private int process(String word1, String word2, int index1, int index2, int step) {
        if (index1 == word1.length() && index2 == word2.length())
            return step;
        if (index1 == word1.length())
            return process(word1, word2, index1, index2 + 1, step + 1);
        if (index2 == word2.length())
            return process(word1, word2, index1 + 1, index2, step + 1);

        int pMax = Integer.MAX_VALUE;
        if (word1.charAt(index1) == word2.charAt(index2))
            pMax = process(word1, word2, index1 + 1, index2 + 1, step);
        else
            //替换
            pMax = process(word1, word2, index1 + 1, index2 + 1, step + 1);
        //插入
        pMax = Math.min(pMax, process(word1, word2, index1, index2 + 1, step + 1));
        //删除
        pMax = Math.min(pMax, process(word1, word2, index1 + 1, index2, step + 1));
        return pMax;
    }
}
