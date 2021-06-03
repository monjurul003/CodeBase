package mik.bitquill;

import java.util.Arrays;

/*
 42. Trapping Rain Water
 Given n non-negative integers representing an elevation map where the width of each bar is 1,
 compute how much water it is able to trap after raining.
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/
public class TrappingTheRainWater {
    public static int trapBruteForce(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int leftmax = 0, rightmax = 0, sum = 0;
        for (int i = 0; i < height.length; i++) {
            int j = i;
            while (j >= 0) {
                leftmax = Math.max(leftmax, height[j]);
                j--;
            }
            j = i;
            while (j < height.length) {
                rightmax = Math.max(rightmax, height[j]);
                j++;
            }
            sum += Math.min(leftmax, rightmax) - height[i];
            leftmax = 0;
            rightmax = 0;
        }
        return sum;
    }

    public static int trappingWaterDp(int[] height) {
        int sum = 0;
        if (height == null || height.length == 0) {
            return sum;
        }
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
            right[n - i - 1] = Math.max(height[n - i - 1], right[n - i]);
        }
        Arrays.stream(left).forEach(i -> System.out.print(i + ", "));
        System.out.println();
        Arrays.stream(right).forEach(i -> System.out.print(i + ", "));
        System.out.println();
        Arrays.stream(height).forEach(i -> System.out.print(i + ", "));
        System.out.println();
        for (int i = 0; i < n; i++) {
            sum += Math.min(left[i], right[i]) - height[i];
        }
        System.out.println("from dp = " + sum);
        return sum;
    }

    /*11. Container With Most Water
     * */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0, right = height.length - 1, max = Integer.MIN_VALUE;

        while (left < right) {
            max = Math.max(Math.min(height[left], height[right]) * (right - left), max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] input = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trapBruteForce(input));
        trappingWaterDp(input);
    }
}
