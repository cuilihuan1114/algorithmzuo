
/**
 * @author cuilihuan
 * @data 2021/5/9 14:36
 */
public class Problem_0825_适龄的朋友 {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int age : ages) count[age]++;

        int ans = 0;
        for (int ageA = 0; ageA <= 120; ageA++) {
            int countA = count[ageA];
            for (int ageB = 0; ageB <= 120; ageB++) {
                int countB = count[ageB];
                if (ageA * 0.5 + 7 >= ageB) continue;
                if (ageA < ageB) continue;
                if (ageA < 100 && 100 < ageB) continue;
                ans += countA * countB;
                if (ageA == ageB) ans -= countA;
            }
        }

        return ans;
    }

    public int numFriendRequests1(int[] ages) {
        if (ages == null || ages.length == 0)
            return 0;
        int[] count = new int[121];
        for (int i = 0; i < ages.length; i++) {
            count[ages[i]]++;
        }

        int sum = 0;
        for (int i = 120; i >= 1; i--) {
            if (count[i] > 0) {
                sum += (count[i] - 1) * count[i];
                for (int j = i - 1; j >= 1; j--) {
                    if ((j > i) || (j <= 0.5 * i + 7))
                        continue;
                    sum += count[i] * count[j];
                }
            }
        }

        return sum;

    }
}
