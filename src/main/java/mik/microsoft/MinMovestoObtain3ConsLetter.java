package mik.microsoft;

public class MinMovestoObtain3ConsLetter {
    public static void main(String[] args) {
        String s = "aaabb";
        System.out.println(getminChanges(s));
    }

    private static int getminChanges(String s) {
        int aCount=0, bCount=0, count=0;
        for(char ch : s.toCharArray()) {
            if(ch == 'a') {
                aCount++;
                bCount = 0;
            }
            if(ch == 'b') {
                bCount++;
                aCount = 0;
            }
            if(aCount == 3 || bCount == 3) {
                count++;
                aCount = 0;
                bCount = 0;
            }
        }
        return count;
    }
}
