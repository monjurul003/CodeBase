package mik.bitquill;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;

public class ReverseCharArray {
    public static int reverseCharAray(char[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        printArr(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            arr[left]  = (char) (arr[left] ^ arr[right]);
            arr[right] = (char) (arr[left] ^ arr[right]);
            arr[left]  = (char) (arr[left] ^ arr[right]);
            left++;
            right--;
        }
        printArr(arr);
        return 1;
    }

    public static void printArr(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] ar = new int[]{1,2,3,4,5,6};
        List<int[]> list = asList(ar);
        for(int i = 0; i<list.size(); i++) {
            System.out.println(list.get(i)[0]);
        }
        char[] arr = new char[]{'a','b','c','d','e'};
        reverseCharAray(arr);
    }
}
