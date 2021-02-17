package newstart.programming.graph.courseschedule;

import java.util.*;

public class TopSort {
    public static List<Integer> topSort(int numCourses, int[][] prerequisites){
        List<Integer> result = new ArrayList();
        Map<Integer, Course> map = new HashMap();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new Course(i));
        }
        for (int i = 0; i < prerequisites.length; i++) {
            Course src = map.get(prerequisites[i][1]);
            src.neighbors.add(prerequisites[i][0]);
            map.get(prerequisites[i][0]).indegree++;
        }

        Queue<Integer> q = new LinkedList();
        map.forEach((id,course) -> {
            if(course.indegree == 0){
                q.offer(id);
            }
        });
        while(!q.isEmpty()) {
            Course curr = map.get(q.poll());
            for(Integer neighbourId : curr.neighbors) {
                map.get(neighbourId).indegree--;
                if(map.get(neighbourId).indegree == 0) {
                    q.offer(neighbourId);
                }
            }
            result.add(curr.id);
        }
        return result;
    }
}
