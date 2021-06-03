package newstart.programming.graph.courseschedule;

import java.util.*;
/*207. Course Schedule
* There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return true if you can finish all courses. Otherwise, return false.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.



Constraints:

    1 <= numCourses <= 105
    0 <= prerequisites.length <= 5000
    prerequisites[i].length == 2
    0 <= ai, bi < numCourses
    All the pairs prerequisites[i] are unique.

*/
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
