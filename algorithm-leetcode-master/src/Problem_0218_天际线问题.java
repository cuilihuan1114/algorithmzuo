import java.util.*;
import java.util.Map.Entry;

/**
 * Created by CUI on 2021/1/9
 */
public class Problem_0218_天际线问题 {

    class Node {
        int pos;
        int height;
        boolean add;

        public Node(int pos, int height, boolean add) {
            this.pos = pos;
            this.height = height;
            this.add = add;
        }
    }

    class NodeCompator implements Comparator<Node> {


        @Override
        public int compare(Node o1, Node o2) {
            return o1.pos - o2.pos;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> list = new ArrayList<>();
        if (buildings == null || buildings.length == 0)
            return list;

        Node[] nodes = new Node[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            nodes[2 * i] = new Node(buildings[i][0], buildings[i][2], true);
            nodes[2 * i + 1] = new Node(buildings[i][1], buildings[i][2], false);
        }
        Arrays.sort(nodes, new NodeCompator());

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        TreeMap<Integer, Integer> xMaxHeight = new TreeMap<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].add) {
                if (treeMap.containsKey(nodes[i].height)) {
                    treeMap.put(nodes[i].height, treeMap.get(nodes[i]) + 1);
                } else
                    treeMap.put(nodes[i].height, 1);
            } else {
                if (treeMap.get(nodes[i].height) == 1)
                    treeMap.remove(nodes[i].height);
                else
                    treeMap.put(nodes[i].height, treeMap.get(nodes[i].height) - 1);
            }

            if (treeMap.isEmpty()) {
                xMaxHeight.put(nodes[i].pos, 0);
            } else
                xMaxHeight.put(nodes[i].pos, treeMap.lastKey());
        }

        int preHeight = 0;
        for (Entry<Integer, Integer> entry : xMaxHeight.entrySet()) {
            int pos = entry.getKey();
            int height = entry.getValue();
            if(height!=preHeight){
                List<Integer> curList = new ArrayList<>();
                curList.add(pos);
                curList.add(height);
                list.add(curList);
            }
            preHeight = height;
        }
        return list;
    }
}
