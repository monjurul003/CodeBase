package mik.recursion;

import java.util.HashMap;
import java.util.Map;

public class Recursion {
    //O(n) time and O(n) space complexity recursion. n calls take n stack space in memory so time and space complexity is same
    public void simple(int n) {
        if (n <= 1) return;
        simple(n - 1);
    }

    //O(2^n) time complexity space complexity is O(n) . each level number of nodes going to be double as we are calling the function 2 times.
    //So for the time it will be 2^n. For space complexity one instance of a time there will be only height of the tree will be in the stack space.
    /*
     *                     3           level-0 #nodes:1
     *                   /   \
     *                  2     2        level-1 #nodes:2 (1*2)
     *                 / \   / \
     *                1   1 1   1      level-2 #nodes:4 (2*2)
     * */
    public void dib(int n) {
        if (n <= 1) return;
        dib(n - 1);
        dib(n - 1);
    }

    //O(2^n) time complexity space complexity is O(n)
    public static int fib(int n) {
        if (n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    //Time complexity: O(n), Space complexity: O(n)
    public static int fib(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) return map.get(n);
        if (n <= 2) return 1;
        map.put(n, fib(n - 1, map) + fib(n - 2, map));
        return map.get(n);
    }

    public static void printPattern(int n) {
        if (n <= 0) return;
        System.out.print("a");
        printPattern(n - 1);
        System.out.print("b");
    }

    // Time complexity: O(2^(m+n)) Space complexity: O(m+n) Tree height m+n, every level 2 new nodes generate/2 function call happens so time complexity O(2^(m+n))
    public static int gridTraveller(int m, int n) {
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        return gridTraveller(m - 1, n) + gridTraveller(m, n - 1);
    }

    public static int gridTraveller(int m, int n, Map<String, Integer> map) {
        String key = n + "," + m;
        if (map.containsKey(key)) return map.get(key);
        key = m + "," + n;
        if (map.containsKey(key)) return map.get(key);
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        map.put(key, gridTraveller(m - 1, n, map) + gridTraveller(m, n - 1, map));
        return map.get(key);
    }
    //if m = targetSum and n = array length then Time Complexity: O(n^m) Space complexity: O(m). m is the height of tree (assuming we have lowest positive number 1 in the array).
    // every level there will be n branch. so branching factor is n. Therefore, O(n^m)
    public static boolean canSum(int target, int[] nums) {
        if (target == 0) return true;
        if(target < 0) return false;
        for (int i :
                nums) {
            if (target % i == 0) return true;
            int remainder = target - i;
            if(canSum(remainder,nums)) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        printPattern(5);
        System.out.println(fib(7, new HashMap<>()));
        System.out.println(gridTraveller(2, 3, new HashMap<>()));
        System.out.println(canSum(7,new int[]{2,3}));
    }
}
