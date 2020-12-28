package basic;

/**
 * N皇后问题的两种解法
 */
public class NQueens {
    public static int num1(int row) {
        int[] record = new int[row];
        return process(0, row, record);
    }

    public static int process(int n, int row, int[] record) {
        if (n == row) {
//            printQueue(record, row);
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < row; i++) {
            if (isOk(n, i, record)) {
                record[n] = i;
                sum += process(n + 1, row, record);
            }
        }
        return sum;
    }

    private static void printQueue(int[] record, int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (j == record[i]) {
                    System.out.print("Q");
                } else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("================");

    }

    public static boolean isOk(int n, int pos, int[] record) {
        for (int i = 0; i < n; i++) {
            if (record[i] == pos || Math.abs(n - i) == Math.abs(pos - record[i])) {
                return false;
            }
        }
        return true;
    }


    public static int num2(int n) {
        if (n < 0 || n > 32)
            return -1;
        //一定要注意括号
        int limit = (1 << n) - 1;
        return process1(limit, 0, 0, 0);
    }

    /**
     * 利用位来表示限制条件 减少常数时间的依赖
     *
     * @param limit    整个行或列 保持不变
     * @param colLim   每列所占的位置
     * @param leftLim  左限制
     * @param rightLim 右限制
     * @return 返回总共的个数
     */
    public static int process1(int limit, int colLim, int leftLim, int rightLim) {
        if (limit == colLim) {
            return 1;
        }
        int sum = 0;
        //所有的限制条件 包括行 左列 右列
        int remain = (~(colLim | leftLim | rightLim)) & limit;
        while (remain > 0) {
            //获得右部最后一个1
            int pos = remain & (~remain + 1);
            //减去上面的1
            remain = remain - pos;
            sum += process1(limit, colLim | pos, (leftLim | pos) << 1, (rightLim | pos) >> 1);
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println("start");
        for (int i = 0; i < 10; i++) {
            if(num1(i) != num2(i))
                System.out.println("ops!");
        }
        System.out.println("end");

    }
}
