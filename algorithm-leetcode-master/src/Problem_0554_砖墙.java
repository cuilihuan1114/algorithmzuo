import java.util.HashMap;
import java.util.List;

/**
     * @author cuilihuan
     * @data 2021/3/20 22:33
     */
    public  class Problem_0554_砖墙 {
        public int leastBricks(List<List<Integer>> wall) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < wall.size(); i++) {
                int sum = 0;
                for (int j = 0; j < wall.get(i).size() - 1; j++) {
                    sum += wall.get(i).get(j);
                    if(map.containsKey(sum)){
                        map.put(sum, map.get(sum) + 1);
                    }else
                        map.put(sum, 1);
                }
            }
            int max = 0;
            for(Integer key: map.keySet()){
                max = Math.max(max, map.get(key));
            }
            return wall.size() - max;
        }
    }