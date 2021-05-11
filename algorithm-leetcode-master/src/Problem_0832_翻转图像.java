
/**
 * @author cuilihuan
 * @data 2021/5/11 10:24
 */
public class Problem_0832_翻转图像 {
    public int[][] flipAndInvertImage(int[][] image) {
        if(image == null || image.length == 0)
            return image;

        int[][] ans = new int[image.length][image[0].length];

        for (int i = 0 ; i < image.length; i++) {
            for (int j = image[0].length - 1; j >= 0 ; j--) {
                ans[i][image[0].length - 1 - j] = image[i][j];
                ans[i][image[0].length - 1 - j] = ans[i][image[0].length - 1 - j] ^ 1;
            }
        }

        return ans;
    }
}
