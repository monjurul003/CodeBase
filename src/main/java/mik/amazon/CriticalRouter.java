package mik.amazon;

import java.util.*;

public class CriticalRouter {
    public static int[][] generateMatrix(int[][] edges, int n) {
        int[][] mat = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0];
            int t = edges[i][1];
            mat[s][t] = 1;
            mat[t][s] = 1;
        }
        return mat;
    }

    public static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isCriticalNode(int[][] mat, int skippedNode, int startNode) {
        Queue<Integer> q = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        q.offer(startNode);
        while (!q.isEmpty()) {
            int i = q.poll();
            set.add(i);
            for (int j = 0; j < mat[i].length; j++) {
                if (i == skippedNode || j == skippedNode) {
                    continue;
                }
                if (!set.contains(j) && mat[i][j] == 1) {
                    q.offer(j);
                }
            }
        }
        if(set.size() != mat.length-1) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int numNodes = 7;
        int numEdges = 7;
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};
        int[][] mat = generateMatrix(edges, numNodes);
        List<Integer> list = new ArrayList<>();
//        printMatrix(mat);
        for (int i = 0; i < numNodes; i++) {
            if(isCriticalNode(mat,i,(i+1)%numNodes)) {
                list.add(i);
            }
        }
        System.out.println("List of critical nodes are,");
        for (Integer i :
             list) {
            System.out.print(i +",");

        }
    }
}
