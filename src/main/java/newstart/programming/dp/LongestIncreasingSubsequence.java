package newstart.programming.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            System.out.print("Num - "+num+ ", Len - " + len + ", i- " + i);
            //didn't found
            //now here index is insertion index
            if (i < 0) {
                //covert insertion index in the 0 indexed
                i = -(i + 1);
            }
            System.out.print(", i after -- "+ i+ ", dp -");
            //insert num in the appropriate place,
            //so it always in strictly increasing order
            dp[i] = num;
            for(int n: dp){
                System.out.print(n + ", ");
            }
            System.out.println();

            //it means, new num become the rightmost element of dp
            if (i == len) {
                //increse length of the longest increasing subsequece
                len++;
            }

        }
        return len;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        obj.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
}
