
/**
 * @author cuilihuan
 * @data 2021/5/11 17:17
 */
public class Problem_0856_括号的分数 {
    class Info{
        int pos;
        int num;

        public Info(int pos, int num) {
            this.pos = pos;
            this.num = num;
        }
    }
    public int scoreOfParentheses(String s) {
        if(s == null || s.length() == 0)
            return 0;

        Info ans = process(s, 0);
        return ans.num ;
    }

    private Info process(String s, int index) {
        int sum = 0;
        while (index < s.length()){
            if(s.charAt(index) == '('){
                Info res = process(s, index + 1);
                sum += res.num;
                index = res.pos;
            }else{
                Info res = new Info(index + 1, sum == 0 ? 1 : 2 * sum);
                return res;
            }
        }
        return new Info(-1,sum);
    }


}
