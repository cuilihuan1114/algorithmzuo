 /**
     * @author cuilihuan
     * @data 2021/4/12 10:17
     */
    public  class Problem_0733_图像渲染 {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if (image == null || image.length == 0)
                return image;

            int target = image[sr][sc];
            process(image, sr, sc, target, newColor);
            return image;
        }

        private void process(int[][] image, int sr, int sc, int target, int newColor) {
            if (sr >= image.length || sc >= image[0].length || sc < 0 || sr < 0)
                return;

            if (image[sr][sc] == newColor || image[sr][sc] != target)
                return;

            image[sr][sc] = newColor;
            process(image, sr + 1, sc, target, newColor);
            process(image, sr, sc + 1, target, newColor);
            process(image, sr - 1, sc, target, newColor);
            process(image, sr, sc - 1, target, newColor);
        }
    }