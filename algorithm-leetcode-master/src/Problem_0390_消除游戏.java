/**
 * @author cuilihuan
 * @data 2021/3/5 16:50
 */
public class Problem_0390_消除游戏 {

    public static void main(String[] args) {
        for (int i = 1; i <= 2000; i++) {
            System.out.println(i + "="  + new Problem_0390_消除游戏().lastRemaining1(i));
        }
        //new Problem_0390_消除游戏().lastRemaining(i) + "_"
//        System.out.println(new Problem_0390_消除游戏().lastRemaining1(8));
    }


    public int lastRemaining(int n) {
       if(n == 1) return 1;
        return 2 * (n / 2 - lastRemaining(n / 2) + 1);
    }

    public int lastRemaining1(int n) {
        boolean[] delete = new boolean[n + 1];
        int count = 0;
        boolean flag = false;
        for (int i = 1; i <= delete.length; i++) {
            flag = true;
            if (i % 2 != 0) {
                for (int j = 1; j < delete.length; j++) {
                    if (delete[j])
                        continue;
                    if (flag) {
                        count++;
                        if (count == n)
                            return j;
                        delete[j] = true;
                    }
                    flag = !flag;
                }
            } else {
                for (int j = delete.length - 1; j >= 1; j--) {
                    if (delete[j])
                        continue;
                    if (flag) {
                        count++;
                        if (count == n)
                            return j;
                        delete[j] = true;
                    }
                    flag = !flag;
                }
            }
        }
        return -1;
    }
}
