import java.util.ArrayList;
import java.util.List;

/**
 * Created by CUI on 2021/2/26
 */
public class Problem_0448_找到所有数组中消失的数字 {

    public static void main(String[] args) {
        new Problem_0448_找到所有数组中消失的数字().findDisappearedNumbers(new int[]{
                4, 3, 2, 7, 8, 2, 3, 1});

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return list;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                swap(nums[i] - 1, nums);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }

        return list;
    }

    private void swap(int index, int[] nums) {
        while (nums[index] != index + 1) {
            int nextPos = nums[index] - 1;
            nums[index] = index + 1;
            index = nextPos;
        }
    }
}
