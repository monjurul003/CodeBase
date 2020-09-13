package mik.bitquill;

/*

Write a function that takes an integer as an input n and returns the number of times the digit ‘1’ appears in all positive integers from 0 to n.


For example, when n = 11, we get the sequence 0, 1, 2, 3, … 10, 11 so the result is 4.


int countDigit1(int n);
Input:

n - The String to search through.


Return Value

The number of times 1 occurred in the sequence of integers from 0 to n.
* */
public class Count1 {
    public int get1Count(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 10 == 1) {
                count++;
            }
            n /= 10;
        }
        return count;
    }

    public int countDigit1(int n) {
        if(n == 1) {
            return 1;
        }
        int count = 1;
        for (int i = 10; i <= n; i++) {
            count += get1Count(i);
        }
        return count;
    }
}
