/**
 * @author cuilihuan
 * @data 2021/3/14 14:12
 */
public class Problem_0476_数字的补数 {

    public static void main(String[] args) {
        System.out.println(new Problem_0476_数字的补数().findComplement(2));
    }
    public int findComplement(int num) {
        int sum = 0;
        int i = 0;
        int cur = 0;
        while (num != 0){
            cur = (num  & 1 ) == 1 ? 0 : 1;
            num = (num >> 1);
            if(num == 0)
                break;
            sum += (cur << i);
            i++;
        }
        return sum;
    }
}
