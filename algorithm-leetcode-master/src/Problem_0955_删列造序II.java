
import java.util.*;

/**
 * @author cuilihuan
 * @data 2021/6/1 14:34
 */
public class Problem_0955_删列造序II {
    public static void main(String[] args) {
        System.out.println(new Problem_0955_删列造序II().minDeletionSize(new String[]{"xga", "xfb", "yfa"}));
    }

    public int minDeletionSize(String[] A) {
        int N = A.length;
        int W = A[0].length();
        int ans = 0;

        // cur : all rows we have written
        // For example, with A = ["abc","def","ghi"] we might have
        // cur = ["ab", "de", "gh"].
        String[] cur = new String[N];
        for (int j = 0; j < W; ++j) {
            // cur2 : What we potentially can write, including the
            //        newest column col = [A[i][j] for i]
            // Eg. if cur = ["ab","de","gh"] and col = ("c","f","i"),
            // then cur2 = ["abc","def","ghi"].
            String[] cur2 = Arrays.copyOf(cur, N);
            for (int i = 0; i < N; ++i)
                cur2[i] += A[i].charAt(j);

            if (isSorted(cur2))
                cur = cur2;
            else
                ans++;
        }

        return ans;
    }

    public boolean isSorted(String[] A) {
        for (int i = 0; i < A.length - 1; ++i)
            if (A[i].compareTo(A[i+1]) > 0)
                return false;

        return true;
    }

    public int minDeletionSize1(String[] strs) {
        int ans = 0;
        List<String> list = new ArrayList<>();
        boolean[] indefity = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            list.add(strs[i]);
        }

        return process(list, strs[0].length(), 0);
    }

    private int process(List<String> list, int length, int index) {
        if (index == length)
            return 0;

        List<List<String>> cur = new ArrayList<>();
        boolean flag = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).charAt(index) < list.get(i - 1).charAt(index)) {
                flag = false;
                break;
            } else if (list.get(i).charAt(index) == list.get(i - 1).charAt(index)) {
                List<String> tmp = new ArrayList<>();
                tmp.add(list.get(i - 1));
                while (i < list.size() && list.get(i).charAt(index) == list.get(i-1).charAt(index)){
                   tmp.add(list.get(i));
                   i++;
               }
                cur.add(tmp);
                i--;
            }
        }

        int ans = 0;
        if(!flag){
            ans = process(list, length, index + 1) + 1;
        }else{
            for (int i = 0; i < cur.size(); i++) {
                ans = Math.max(ans, process(cur.get(i), length, index + 1));
            }
        }

        return ans;
    }


}
