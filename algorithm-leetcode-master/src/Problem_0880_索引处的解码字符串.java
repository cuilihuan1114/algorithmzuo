
/**
 * @author cuilihuan
 * @data 2021/5/24 14:46
 */
public class Problem_0880_索引处的解码字符串 {
    public static void main(String[] args) {
        System.out.println(new Problem_0880_索引处的解码字符串().decodeAtIndex("a23", 6));
    }
    public String decodeAtIndex(String s, int k) {
        long sum = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                long pre = sum;
                sum = (c - '0') * sum;
                if(sum >= k){
                    return decodeAtIndex(sb.toString(), (int) ((k - 1) % pre+1));
                }
            }else{
                sum++;
                if(sum == k)
                    return String.valueOf(c);
            }
            sb.append(c);
        }
        return null;
    }
}
