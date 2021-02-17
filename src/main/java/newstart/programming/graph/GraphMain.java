package newstart.programming.graph;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GraphMain {

    public static void initDfsGraph(Map<Integer, Node> map) {
        for (int i = 0; i < 4; i++) {
            map.put(i, new Node(i));
        }
        map.get(0).adj.add(2);
        map.get(0).adj.add(1);
        map.get(2).adj.add(0);
        map.get(2).adj.add(3);
        map.get(3).adj.add(3);
        map.get(1).adj.add(2);

    }
    public static void main(String[] args) {
        Map<Integer, Node> map = new HashMap<>();
        initDfsGraph(map);
        boolean[] visited = new boolean[4];

        //Dfs calling code
//        Dfs dfsObj = new Dfs(map);
//        dfsObj.dfs(0,visited);

        //topological sort calling.
//        TopologicalSort topSortObj = new TopologicalSort(map);
//        topSortObj.topSort(0,visited);
//        topSortObj.printTopSort();
        int[] nums = new int[] {1,2,3,4,5,1,2,3,2,4};
        Map<Integer, Integer> map1 = new HashMap<>();
        for(int i=nums.length-1; i>=0; i--) {
            map1.put(nums[i], map1.getOrDefault(nums[i], 0)+1);
        }
        System.out.println(map1);
        // sort by keys, a,b,c..., and return a new LinkedHashMap
        // toMap() will returns HashMap by default, we need LinkedHashMap to keep the order.
        Map<Integer, Integer> result = map1.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(result);
        int maxLhs = 0;
        for (Integer i:
             result.keySet()) {
            int curr = result.get(i);
            int consecutiveVal = result.getOrDefault(i+1,0);
            maxLhs = Math.max(maxLhs, curr+consecutiveVal);
        }
        System.out.println("max --" + maxLhs);
    }
}
