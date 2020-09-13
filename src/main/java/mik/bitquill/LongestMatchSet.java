package mik.bitquill;

/*
Prob 4.

Write a function that takes a String and returns the number of characters in the longest matched set of (), [], or {}.


For example, the String “(1[234)567]” would return 9, while “()” would return 2.


public static int countParenLength(String input);
Input:

input - The String to search through.


Return Value

The length of the longest substring delimited by a matched set of (), [], or {}, inclusive of the parentheses themselves.


 */
public class LongestMatchSet {
    public int getLongest(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int x = 0, y = 0, z = 0, maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE, maxZ = Integer.MIN_VALUE;
        boolean openedX = false, openedY = false, openedZ = false;
        for (char ch : s.toCharArray()) {
            if (ch == '(' || openedX) {
                x++;
                openedX = true;
            }
            if (ch == ')' && openedX) {
                maxX = Math.max(maxX, x);
                openedX = false;
                x = 0;
            }

            if (ch == '{' || openedY) {
                y++;
                openedY = true;
            }
            if (ch == '}' && openedY) {
                maxY = Math.max(maxY, y);
                openedY = false;
                y = 0;
            }
            if (ch == '[' || openedZ) {
                z++;
                openedZ = true;
            }
            if (ch == ']' && openedZ) {
                maxZ = Math.max(maxZ, z);
                openedZ = false;
                z = 0;
            }
        }
        return Math.max(maxX, Math.max(maxY, maxZ));
    }

    public static void main(String[] args) {
        System.out.println();
       // System.out.println(getLongest("()"));
    }
}
