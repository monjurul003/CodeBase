package newstart.programming.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int id;
    public List<Integer> adj;

    public Node(int id) {
        this.id = id;
        this.adj = new ArrayList<>();
    }
}
