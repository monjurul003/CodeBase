package mik.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DumpCode {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        list.forEach(System.out::println);
//        int[] nums = {9,8,7,6,5};
//        String str= Arrays.toString(nums);
//        int i = Integer.parseInt(str.replaceAll("[^0-9+]", ""));
//        i++;
//        System.out.println(i);
//        StringBuilder sb = new StringBuilder(str);
//        System.out.println(sb.reverse().toString());
//
//        int[] arr = new int[2];
//        Arrays.fill(arr,5);
//        for (int i1 = 0; i1 < arr.length; i1++) {
//            System.out.println(arr[i1]);
//        }
//        arr = Arrays.copyOf(nums,5);
//        for (int i1 = 0; i1 < arr.length; i1++) {
//            arr[i1]++;
//            System.out.println(arr[i1]);
//        }
//        for(int l: nums){
//            System.out.println(l);
//        }

        int[] nums = list.stream().mapToInt(i->i).toArray();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);

        }
        ArrayList<String> strList = new ArrayList<String>();
        strList.add("test-1");
        strList.add("test-2");
        String[] strArr = strList.toArray(new String[strList.size()]);
        for (String s:
             strArr) {
            System.out.println(s);
        }

    }


}
