package newstart.programming.graph;

import java.util.*;

public class TopologicalSort {
    Map<Integer, Node> map;
    Stack<Integer> topSort;

    public TopologicalSort() {
        this.map = new HashMap<>();
        this.topSort = new Stack<>();
    }

    public TopologicalSort(Map<Integer, Node> map) {
        this.map = map;
        this.topSort = new Stack<>();
    }

    public void topSort(int id, boolean[] visited) {
        if(visited[id]) return;

        visited[id] = true;
        for(Integer adjNodeId: map.get(id).adj) {
            if(!visited[adjNodeId]) {
                topSort(adjNodeId,visited);
            }
        }
        this.topSort.push(id);
    }
    public void printTopSort(){
        while(!this.topSort.isEmpty()) {
            System.out.print(this.topSort.pop() +" ");
        }
        System.out.println();
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return false;

         Map<Integer, Set<Integer>> map = new HashMap();
         int[] indegree = new int[numCourses];
         for(int i=0; i< numCourses; i++) {
             map.put(i, new HashSet());
         }
         for(int i=0; i < prerequisites.length; i++) {
             map.get(prerequisites[i][1]).add(prerequisites[i][0]);
             indegree[prerequisites[i][1]]++;
         }
         ;
         Queue<Integer> q = new LinkedList();
         // Arrays.asList(numCourses).forEach(i -> if(i==0){q.offer(i);});
         for(int i=0; i< numCourses; i++) {
             if(indegree[i] != 0){
                 q.offer(i);
             }
         }
         System.out.println(map);
         while(!q.isEmpty()) {
             int cur = q.poll();

             for(Integer i: map.get(cur)) {
                 System.out.println(q);
                 q.offer(i);
                 indegree[i]--;
             }
         }
          for(int i=0; i< numCourses; i++) {
             System.out.print(indegree[i] + ",");
          }
         System.out.println();

         for(int i=0; i< numCourses; i++) {
             if(indegree[i] > 0){
                 return false;
             }
         }
         return true;

    }
}
