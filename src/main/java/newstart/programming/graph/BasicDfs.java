package newstart.programming.graph;

import java.util.HashMap;
import java.util.Map;

public class BasicDfs {
    Map<Integer, Node> map = new HashMap<>();

    public BasicDfs(Map<Integer, Node> map) {
        this.map = map;
    }

    void dfs(int id, boolean[] visited){
        if(visited[id]) return;
        visited[id] = true;
        System.out.print(id + " ");
        for(Integer childId: map.get(id).adj) {
            if(!visited[childId]) {
                dfs(childId, visited);
            }
        }
        return;
    }
}