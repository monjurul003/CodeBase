package mik.microsoft;

import java.util.List;

/*
1239. Maximum Length of a Concatenated String with Unique Characters
Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

Return the maximum possible length of s.
Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
Maximum length is 4.

Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible solutions are "chaers" and "acters".

Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26

*/
public class MaxLengthUniqueSubstring {
    int count = 0;

    public int maxLength(List<String> arr) {
        findMax(arr, 0, "");
        return count;
    }

    private boolean isUnique(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            if (freq[ch - 'a'] > 0) {
                return false;
            }
            freq[ch - 'a']++;
        }
        return true;
    }

    private void findMax(List<String> arr, int index, String ans) {
        if (isUnique(ans)) {
            count = Math.max(count, ans.length());
        }
        for (int i = index; i < arr.size(); i++) {
            findMax(arr, i + 1, ans + arr.get(i));
        }
    }
}
