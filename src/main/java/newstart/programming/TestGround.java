package newstart.programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestGround {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,7,8,9,3};
        //print array
        Arrays.stream(arr).forEach(n-> System.out.print(n+", "));
        //arr -> list
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        //Get max from int[]
        int max = Arrays.stream(arr).max().getAsInt();
        //Get min from List<Integer>
        int min = list.stream().mapToInt(i-> i).min().getAsInt();


        System.out.println(max+ "," + min);
    }
}
