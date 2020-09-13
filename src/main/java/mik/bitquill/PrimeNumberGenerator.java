package mik.bitquill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumberGenerator {
    static int[] primeArray;
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> getPrimeNumbers(int N) {
        List<Integer> list = new ArrayList<>();
        primeArray = new int[N+1];
        Arrays.fill(primeArray,0);
        primeArray[2] = 1;
        primeArray[3] = 1;
        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public static void generatePrimeArray() {
        int n = primeArray.length;
        for(int i=4; i<n; i++) {

        }
    }

    public static void main(String[] args) {
        List<Integer> list = getPrimeNumbers(15);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
