package newstart.programming.crackingthecodinginterview;

public class ArraysAndString {
    //with extra fixed memory this can be extended to ASCII chars by increasing the array size to 256 and no need to subtract
    public static boolean isUniquechars(String s) {
        boolean[] exists = new boolean[26];
        for (char ch : s.toCharArray()) {
            if (exists[ch - 'a']) {
                return false;
            }
            exists[ch - 'a'] = true;
        }
        return true;
    }

    //with less memory and assume a~z
    public static boolean isUniquechars2(String s) {
        int maskedChecker = 0;
        for (char ch : s.toCharArray()) {
            int val = ch - 'a';
            if ((maskedChecker & (1 << val)) > 0) {
                return false;
            }
            maskedChecker |= 1 << val;
        }
        return true;
    }
}
