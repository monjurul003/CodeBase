package newstart.programming.graph.courseschedule;

import java.util.HashSet;
import java.util.Set;

public class Course {
    int id, indegree;
    Set<Integer> neighbors;

    public Course(int id) {
        this.id = id;
        this.neighbors = new HashSet();
    }
}
