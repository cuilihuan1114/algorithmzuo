import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by CUI on 2021/1/12
 */
public class Problem_0299_猜数字游戏 {
    public String getHint(String secret, String guess) {
        int[] nums = new int[10];
        List<Character> cur = new LinkedList<>();
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }else{
                nums[secret.charAt(i) - '0']++;
                cur.add(guess.charAt(i));
            }
        }

        for (int i = 0; i < cur.size(); i++) {
            if (nums[cur.get(i) - '0'] > 0 ) {
                cows++;
                nums[cur.get(i) - '0']  = nums[cur.get(i) - '0']  -1;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
