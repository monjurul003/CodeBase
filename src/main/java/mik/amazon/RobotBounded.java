package mik.amazon;

import java.util.Arrays;

/*1041. Robot Bounded In Circle
* On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:

    "G": go straight 1 unit;
    "L": turn 90 degrees to the left;
    "R": turn 90 degrees to the right.

The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.



Example 1:

Input: instructions = "GGLLGG"
Output: true
Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.

Example 2:

Input: instructions = "GG"
Output: false
Explanation: The robot moves north indefinitely.

Example 3:

Input: instructions = "GL"
Output: true
Explanation: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...



Constraints:

    1 <= instructions.length <= 100
    instructions[i] is 'G', 'L' or, 'R'.

*/
public class RobotBounded {

    private int[] changeDirection(int[] direction, char d) {
        int[] north = new int[]{1, 0};
        int[] east = new int[]{0, 1};
        int[] south = new int[]{-1, 0};
        int[] west = new int[]{0, -1};
        if (d == 'L') {
            if (Arrays.equals(direction, north)) return west;
            else if (Arrays.equals(direction, west)) return south;
            else if (Arrays.equals(direction, south)) return east;
            else if (Arrays.equals(direction, east)) return north;

        }
        if (d == 'R') {
            if (Arrays.equals(direction, north)) return east;
            else if (Arrays.equals(direction, west)) return north;
            else if (Arrays.equals(direction, south)) return west;
            else if (Arrays.equals(direction, east)) return south;
        }
        return north;
    }

    public boolean isRobotBounded(String instructions) {

        int x = 0, y = 0;
        int[] direction = changeDirection(null, 'G'); //starting direction

        // within 4 cycles should return

        for (int i = 0; i < 4; i++) {

            for (char c : instructions.toCharArray()) {
                if (c == 'G') {
                    x += direction[0];
                    y += direction[1];
                } else {
                    direction = changeDirection(direction, c);
                }
            }

            if (x == 0 & y == 0)
                return true;
        }//four times at most

        return false;
    }

    public static void main(String[] args) {
        RobotBounded obj = new RobotBounded();
        boolean result = obj.isRobotBounded("GGLLGG");
        System.out.println(result);
    }
}
