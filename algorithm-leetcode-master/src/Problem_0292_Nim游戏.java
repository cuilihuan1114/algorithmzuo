/**
 * Created by CUI on 2021/1/10
 */
public class Problem_0292_Nim游戏 {
    public static void main(String[] args) {
        Problem_0292_Nim游戏 test = new Problem_0292_Nim游戏();
        for (int i = 1; i < 1000; i++) {
//            if (test.canWinNim(i) != test.canWinNim1(i))
                System.out.println(i + "-->"+test.canWinNim1(i));
        }
        System.out.println("test finsh");
    }

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    //超出内存限制 1348820612
    public boolean canWinNim1(int n) {
        int[] leftCache = new int[n + 1];
        return left(n, leftCache);
    }

    private boolean left(int n, int[] leftCache) {
        if (n <= 0)
            return false;
        if (leftCache[n] != 0)
            return leftCache[n] == 1;
        boolean flag = false;
        flag = flag || !left(n - 1, leftCache);
        flag = flag || !left(n - 2, leftCache);
        flag = flag || !left(n - 3, leftCache);
        leftCache[n] = (flag ? 1 : -1);
        return flag;
    }

//    private boolean right(int n, int[] leftCache, int[] rightCache) {
//        if(n <= 0)
//            return false;
//        if(rightCache[n] != 0)
//            return rightCache[n] == 1;
//        boolean flag = false;
//        flag = flag || !left(n - 1, leftCache, rightCache);
//        flag = flag || !left(n - 2, leftCache, rightCache);
//        flag = flag || !left(n - 3, leftCache, rightCache);
//        rightCache[n] = (flag ? 1 : -1);
//        return flag;
//    }
}
