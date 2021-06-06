
import java.util.HashSet;

/**
 * @author cuilihuan
 * @data 2021/5/28 15:31
 */
public class Problem_0929_独特的电子邮件地址 {
    public int numUniqueEmails(String[] emails) {
        if(emails == null || emails.length == 0)
            return 0;

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            StringBuffer sb = new StringBuffer();
            String email = emails[i];
            boolean flag = true;
            for (int j = 0; j < email.length(); j++) {
                if(flag && email.charAt(j) >= 'a' && email.charAt(j) <= 'z'){
                    sb.append(email.charAt(j));
                }else if(email.charAt(j) == '+'){
                    flag = false;
                }else if(email.charAt(j) == '@'){
                    sb.append(email.substring(j));
                    break;
                }
            }
            set.add(sb.toString());
        }

        System.out.println(set);

        return set.size();
    }
}
