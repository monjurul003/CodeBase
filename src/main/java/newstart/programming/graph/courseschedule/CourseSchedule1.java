package newstart.programming.graph.courseschedule;

import java.util.List;

public class CourseSchedule1 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> list = TopSort.topSort(numCourses,prerequisites);
        System.out.println(list);
        return list.size() == numCourses;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1,0}, {0,1}}));
    }
}
