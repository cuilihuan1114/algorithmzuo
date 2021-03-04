import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by CUI on 2021/3/1
 */
public class Problem_0350_两个数组的交集II {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if(map.containsKey(nums1[i])){
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }else
                map.put(nums1[i], 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i])){
                if(map.get(nums2[i]) == 1)
                    map.remove(nums2[i]);
                else
                    map.put(nums2[i], map.get(nums2[i]) - 1);

                list.add(nums2[i]);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
