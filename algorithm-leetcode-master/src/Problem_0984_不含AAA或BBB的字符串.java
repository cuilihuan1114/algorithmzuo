
/**
 * @author cuilihuan
 * @data 2021/5/29 14:50
 */
public class Problem_0984_不含AAA或BBB的字符串 {
    public static void main(String[] args) {
        System.out.println(new Problem_0984_不含AAA或BBB的字符串().strWithout3a3b(5, 5));
    }
    public String strWithout3a3b(int a, int b) {
        StringBuffer sb = new StringBuffer();
        int max = Math.max(a, b);
        int tmp = max;
        int min = Math.min(a, b);

        while (max > 0){

            sb.append('a');
            max--;
            if(max <= 0)
                break;

            sb.append('a');
            max--;

            if(min <= 0)
                break;

            sb.append('b');
            min--;
        }

        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < sb.length(); i++) {
            if(min == 0){
                ans.append(sb.substring(i));
                break;
            }
            ans.append(sb.charAt(i));
            if(sb.charAt(i) == 'b')
                continue;
            ans.append('b');
            min--;
        }
        if(tmp != a){
            for (int i = 0; i < ans.length(); i++) {
                if(ans.charAt(i) == 'a')
                    ans.setCharAt(i, 'b');
                else
                    ans.setCharAt(i, 'a');
            }
        }

        return ans.toString();
    }
}
