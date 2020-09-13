package mik.rise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 438. Find All Anagrams in a String
* Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

* */
public class FindAllAnagramInString438 {
    public static void main(String[] args) {
        String s = "cbadrbacab";
        String p = "abc";
        System.out.println(findAnagrams(s,p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result= new ArrayList<>();
        if(s == null || p == null || s.length() < p.length()){
            return result;
        }
        int n = s.length();
        int m = p.length();
        int[] sFreq = new int[26];
        int[] pFreq = new int[26];
        for (int i = 0; i < m; i++) {
            pFreq[p.charAt(i)-'a']++;
            sFreq[s.charAt(i)-'a']++;
        }

        for (int i = m; i < n; i++) {
            if(Arrays.equals(sFreq,pFreq)) {
                result.add(i-m);
            }
            sFreq[s.charAt(i)-'a']++;
            sFreq[s.charAt(i-m)-'a']--;
        }
        if(Arrays.equals(sFreq,pFreq)) {
            result.add(n-m);
        }
            return result;

    }
}
