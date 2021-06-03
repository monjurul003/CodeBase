package newstart.programming.ds;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class LambdaRelated {

    //for lists
    public static <T, U> List<U> convertList(List<T> from, Function<T, U> func) {
        return from.stream().map(func).collect(Collectors.toList());
    }

    //for arrays
    public static <T, U> U[] convertArray(T[] from,
                                          Function<T, U> func,
                                          IntFunction<U[]> generator) {
        return Arrays.stream(from).map(func).toArray(generator);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        Arrays.sort(arr);
        //int[] -> LinkedList

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(list);


        //for lists
        List<String> stringList = Arrays.asList("1", "2", "3");
        List<Integer> integerList = convertList(stringList, s -> Integer.parseInt(s)); //List<Integer> integerList = convertList(stringList, Integer::parseInt);
        List<Double> doubleList = convertList(stringList,s->Double.parseDouble(s));

        //for arrays
        String[] stringArr = {"1", "2", "3"};
        Double[] doubleArr = convertArray(stringArr, Double::parseDouble, Double[]::new);
    }
}
