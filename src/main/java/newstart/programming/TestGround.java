package newstart.programming;

import java.util.*;
import java.util.stream.Collectors;

public class TestGround {

    public static void printList(List<?> list) {
        list.stream().forEach(System.out::print);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 7, 8, 9, 3};
        //print array
        Arrays.stream(arr).forEach(n -> System.out.print(n + ", "));
        //arr -> list
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        //Get max from int[]
        int max = Arrays.stream(arr).max().getAsInt();
        //Get min from List<Integer>
        int min = list.stream().mapToInt(i -> i).min().getAsInt();

        System.out.println(max + "," + min);

        //String to List<Integer>
        List<String> strList = Arrays.asList("1", "2", "3", "6", "7", "8");
        list = strList.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        list = strList.stream().mapToInt(s -> Integer.parseInt(s)).boxed().collect(Collectors.toList());
        list.stream().forEach(i -> System.out.print(i + ", "));

        System.out.println("int list");
        printList(list);
        list.add(99);

        strList = list.stream().map(i -> i + "").collect(Collectors.toList());
        System.out.println("\n string list");
        printList(strList);

        Map<Integer, String> map = new HashMap();
        map.put(null, "");
        map.put(1, null);
        map.put(2, "test");
        list = map.keySet().stream().collect(Collectors.toList());
        strList = map.values().stream().collect(Collectors.toList());
        System.out.println("int list");
        printList(list);
        System.out.println("\n string list");
        printList(strList);
        // System.out.println(", sum -> "+list.stream().reduce(1,(a,b)->a+b));

    }
}
