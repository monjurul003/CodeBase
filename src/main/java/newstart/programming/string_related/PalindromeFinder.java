package newstart.programming.string_related;

import java.util.HashSet;
import java.util.Set;

public class PalindromeFinder {

    public boolean isPalindrome1(String str) {
        int[] count = new int[26];
        for (char ch : str.toCharArray()) {
            count[ch - 'a'] = count[ch - 'a'] == 0 ? count[ch - 'a'] + 1 : count[ch - 'a'] - 1;
        }
        int oddCount = 0;
        for (char ch : str.toCharArray()) {
            if (count[ch - 'a'] > 0) oddCount++;
        }
        return oddCount <= 1;
    }

    public boolean isPalindrome2(String str) {
        int i = 0, j = str.length() - 1;
        char[] arr = str.toCharArray();
        while (i < j) {
            if (arr[i++] != arr[j--]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome3(String str) {
        Set<Character> set = new HashSet();

        for (char ch :
                str.toCharArray()) {
            if (set.contains(ch)) {
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        return set.size() <= 1;
    }
}
