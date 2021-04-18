/**
 * @author cuilihuan
 * @data 2021/4/13 9:02
 */
public class Problem_0764_最大加号标志 {

    public static void main(String[] args) {
        System.out.println(new Problem_0764_最大加号标志().orderOfLargestPlusSign(5, new int[][]{{4, 2}}));
    }

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] num = new int[N][N];
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                num[i][j] = 1;
            }
        }

        for (int i = 0; i < mines.length; i++) {
            num[mines[i][0]][mines[i][1]] = 0;
        }

        int[][] bottom = new int[N][N];
        for (int i = num.length - 1; i >= 0; i--) {
            for (int j = 0; j < num[i].length; j++) {
                if (num[i][j] != 0) {
                    bottom[i][j] = (i < num.length - 1 ? bottom[i + 1][j] : 0) + 1;
                }
            }
        }

        int[][] right = new int[N][N];
        for (int i = 0; i < num.length; i++) {
            for (int j = num[i].length - 1; j >= 0; j--) {
                if (num[i][j] != 0) {
                    right[i][j] = (j < num.length - 1 ? right[i][j + 1] : 0) + 1;
                }
            }

        }

        int max = 0;
        int[] top = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            int left = 0;
            for (int j = 0; j < num[i].length; j++) {
                if (num[i][j] != 0) {
                    left++;
                    top[j] = top[j] + 1;
                    max = Math.max(max, Math.min(left, Math.min(right[i][j], Math.min(top[j], bottom[i][j]))));
                } else {
                    left = 0;
                    top[j] = 0;
                }
            }
        }
        return max;
    }
}