package newstart.programming.ds;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaRelated {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        //int[] -> LinkedList

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(list);
    }
}
