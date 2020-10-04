package mik.microsoft;
/* Problem description
An infrastructure consisting of N cities, numbered from 1 to N, and M bidirectional roads between them is given. Roads do not intersect apart from at their start and end points (they can pass through underground tunnels to avoid collisions).

For each pair of cities directly connected by a road, let's define their network rank as the total number of roads that are connected to either of the two cities.

Write a function: A

class Solution { public int solution (int[] A, int[] B, int N); }

that, given two arrays A, B consisting of M integers each and an integer N, where A[] and B[i] are cities at the two ends of the i-th road, returns the maximal network rank in the whole infrastructure.

Examples:

1. Given A = [1, 2, 3, 3], B = [2, 3, 1, 4) and N = 4, the function should return 4. The chosen cities may be 2 and 3, and the four roads connected to them are: (2, 1), (2, 3), (3, 1), (3, 4).

In the pictures below, the chosen cities and roads connected to them are marked in red.
* */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxNetworkRank {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 3};
        int[] B = {2, 3, 1, 4};
        int N = 4;

        System.out.println("expected " + 4 + " actual " + solution(A, B, N));
    }

    private static int solution(int[] a, int[] b, int n) {
        int maxRank = 0;
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for(int i = 0; i< a.length; i++) {
            if(!map.containsKey(a[i])) {
                map.put(a[i], new HashSet<>());
            }
            map.get(a[i]).add(b[i]);
            if(!map.containsKey(b[i])) {
                map.put(b[i], new HashSet<>());
            }
            map.get(b[i]).add(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            int cur = map.get(a[i]).size() + map.get(b[i]).size() - 1;
            maxRank = Math.max(cur, maxRank);
        }
        return maxRank;

    }
}
