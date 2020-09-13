package mik.microsoft;

/*
 * Given a string S, find the largest alphabetic character,
 * whose both uppercase and lowercase appear in S.
 * The uppercase character should be returned.
 * For example, for S = "admeDCAB", return "D". If there is no such character,
 * return "NO".
 * */
public class LargestAlphabeticChar {
    public static void main(String[] args) {
        System.out.println(lasrgestCharacter("admeDCAB"));
    }

    public static String lasrgestCharacter(String s) {
        if (s == null || s.length() == 0) {
            return "NO";
        }
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower[ch - 'a'] = true;
            } else {
                upper[ch - 'A'] = true;
            }
        }
        int i = 25;
        while (i >= 0) {
            if(upper[i] && lower[i]) {
                return (char)(i+'A')+"";
            }
            i--;
        }
        return "NO";
    }
}
