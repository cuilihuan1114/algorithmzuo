
import java.util.Arrays;

/**
 * @author cuilihuan
 * @data 2021/5/11 19:36
 */
public class Problem_0881_救生艇 {
    public int numRescueBoats(int[] people, int limit) {
        if(people == null || people.length == 0)
            return 0;
        Arrays.sort(people);

        int start = 0;
        int end = people.length - 1;

        int ans = 0;
        while (start <= end){
            if(people[end] > limit || people[start] + people[end] > limit) {
                end--;
            }else {
                start++;
                end--;
            }
            ans++;
        }

        return ans;

    }
}
