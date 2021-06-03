package mik.bestbuy;

public class ReverseInteger {
    public int reverse(int n) {
        if (n / 10 < 0) return n;
        int rev = 0;
        while (n > 0) {
            int digit = n % 10;
            int temp = rev * 10 + digit;
            if(rev != (temp-digit)/10){
                return -1;
            }
            rev = temp;
            n /= 10;
        }
        return rev;
    }
}
