import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
     * @author cuilihuan
     * @data 2021/3/20 9:21
     */
    public  class Problem_0508_出现次数最多的子树元素和 {

        class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        public int[] findFrequentTreeSum(TreeNode root) {
            HashMap<Integer, Integer> map = new HashMap<>();
            process(root, map);

            int max = 0;
            for(Integer key : map.keySet()){
                max = Math.max(map.get(key), max);
            }

            List<Integer> list = new ArrayList<>();
            for(Integer key : map.keySet()){
                if(map.get(key) == max)
                    list.add(key);
            }

            int[] array = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                array[i] = list.get(i);
            }
            return array;
        }

        public int process(TreeNode root, HashMap<Integer, Integer> map) {
            if (root == null)
                return 0;
            int cur = root.val;
            cur += process(root.left, map);
            cur += process(root.right, map);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else
                map.put(cur, 1);
            return cur;
        }
    }