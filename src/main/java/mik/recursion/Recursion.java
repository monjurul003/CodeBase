package mik.recursion;

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
        if (n<=1) return;
        dib(n-1);
        dib(n-1);
    }

    public static void printPattern(int n) {
        if (n <= 0) return;
        System.out.print("a");
        printPattern(n-1);
        System.out.print("b");
    }

    public static void main(String[] args) {
        printPattern(5);
    }
}
