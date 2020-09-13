package mik.microsoft;

/*

Find set of m-elements with difference of any two elements is divisible by k

Given an array of n-positive integers and a positive integer k,
find a set of exactly m-elements such that difference of any two element is equal to k.
Input : arr[] = {4, 7, 10, 6, 9},
        k = 3, m = 3
Output : Yes
         4 7 10

Input : arr[] = {4, 7, 10, 6, 9},
        k = 12, m = 4
Output : No

Input : arr[] = {4, 7, 10, 6, 9},
        k = 3, m = 4
Output : No
* */
public class MalignedSubset {

    public static void main(String[] args) {
        int[] array = {-3, -2, 1, 0, 8, 7, 1};
        int a = getLargestMAlignedSubset(array, 3);
        System.out.println(a);

    }

    private static int getLargestMAlignedSubset(int[] array, int M) {
        if (array == null || array.length == 0 || M == 0) {
            return 0;
        }
        int result = 0, length = array.length;
        //keep track of subset from 0 to M-1
        int[] subsetArr = new int[M];
        for (int i :
                array) {
            // get reminders, and convert non-positive reminders to non-negative
            int index = i < 0 ? (i % M + M) % M : i % M;
            result = Math.max(++subsetArr[index], result);
        }
        return result;
    }
}
