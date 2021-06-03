package mik.microsoft;

public class MinAdjNumOfSwapsToGetPalindrome {

    /**
     * Algorithm:
     *     1. First check the given string is a jumbled/shuffled palindrome or not.
     *     2. Next have two pointers p1 at 0 and p2 at s.length - 1 and start iterating.
     *     3. If chars at both the pointers are same then just shrink the window (increase the p1 and decrease the p2).
     *     4. or Else
     *          a. find the matching pair and swap the char to p2 index (increase swap count while swapping) and finally shrink the window.
     *          b. if not found just swap once with adjacent index and increase the swap count (do not shrink the window here)
     *     5. Print the Swap Count
     *
     * Time Complexity: O(n) to find Palindrome + [ O(n) for two pointer iteration * O(n) for checking and swapping ] so => O(n^2)
     * Space Complexity: O(n)
     *
     */
    public int getNoOfSwaps(String s) {
        if (s == null || s.length() == 0) return -1;
        int result = 0;
        char[] arr = s.toCharArray();
        if (isShuffledPalindrome(s)) {
            int p1 = 0, p2 = s.length() - 1;
            while (p1 < p2) {
                if (arr[p1] == arr[p2]) {  //When the characters are equal move on
                    p2--;
                    p1++;
                } else {
                    int k = p2;
                    while (arr[k] != arr[p1] && k > p1) {
                        k--;
                    }
                    if (k == p1) { //When no matching character found
                        swap(arr, k, k + 1);
                        result++;
                    } else {
                        while(k<p2) { //When Matching character found swap until K reaches p2 position
                            swap(arr, k, k+1);
                            result++;
                            k++;
                        }
                        p1++;
                        p2--;
                    }

                }
            }
        }
        return result > 0 ? result : -1;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean isShuffledPalindrome(String s) {
        int[] freq = new int[26];
        for (char ch :
                s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int oddCount = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }
}
