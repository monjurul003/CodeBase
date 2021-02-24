package newstart.programming.dp;

public class LongestCommonSubsequence {

    /*1143. Longest Common Subsequence
    Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.



If there is no common subsequence, return 0.



Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

    * */

    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;

        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                dp[i][j] = arr1[i - 1] == arr2[j - 1] ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}
