
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author cuilihuan
 * @data 2021/5/29 14:21
 */
public class Problem_0950_按递增顺序显示卡牌 {
    public int[] deckRevealedIncreasing(int[] deck) {
        if(deck == null || deck.length == 0)
            return deck;

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            list.addLast(i);
        }

        Arrays.sort(deck);

        int[] ans = new int[deck.length];
        for (int i = 0; i < deck.length; i++) {
            ans[list.pollFirst()] = deck[i];
            if (!list.isEmpty())
                list.addLast(list.pollFirst());
        }
        return ans;
    }
}
