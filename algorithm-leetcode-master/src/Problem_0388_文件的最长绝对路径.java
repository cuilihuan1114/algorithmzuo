import java.util.HashMap;

/**
 * @author cuilihuan
 * @data 2021/3/5 11:01
 */
public class Problem_0388_文件的最长绝对路径 {

    public static void main(String[] args) {
        System.out.println(new Problem_0388_文件的最长绝对路径().lengthLongestPath(
                "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }

    public int lengthLongestPath(String input) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(-1, 0);
        int[] max = new int[1];
        process(input, max, map, 0);
        return max[0] > 0 ? max[0] - 1 : 0;
    }

    private void process(String input, int[] max, HashMap<Integer, Integer> map, int index) {
        if(index == input.length())
            return;


        int tofNums = 0;
        StringBuilder curString = new StringBuilder();
        boolean isFile = false;

        while (index < input.length()) {
            if (input.charAt(index) == '.')
                isFile = true;
            if (input.charAt(index) == '\n') {
                index = index + 1;
                break;
            }
            if (input.charAt(index) == '\t') {
                index = index + 1;
                tofNums++;
                continue;
            }
            curString.append(input.charAt(index++));
        }

        map.put(tofNums, map.get(tofNums - 1) + curString.length() + 1);

        if(isFile){
            max[0] = Math.max(max[0], map.get(tofNums));
        }

        process(input,max,map,index);

    }
}
