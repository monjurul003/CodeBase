package mik.microsoft;

import java.util.HashMap;
import java.util.Map;

public class NumberWithEqualDigitSum {
    public static int digitSum(int n){
        int result = 0;
        while(n>0){
            result += n % 10;
            n /= 10;
        }
        return result;
    }
    public static int getMaxPairs(int[] arr){
        if(arr == null || arr.length == -1) {
            return -1;
        }
        Map<Integer, Integer> map  = new HashMap<>();
        int max=-1;
        for(int i : arr) {
            int digitSum = digitSum(i);
            if(!map.containsKey(digitSum)) {
                map.put(digitSum, i);
            } else {

                max = Math.max(max, map.get(digitSum)+i);
                map.put(digitSum,Math.max(map.get(digitSum),i));
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {33,60,42};
        System.out.println(getMaxPairs(arr));
    }
}
