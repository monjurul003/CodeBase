package mik.amazon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingListTest {

    @Test
    void getNumberOfOptions() {
        ShoppingList obj = new ShoppingList();
        //[2, 3], [4], [2, 3], [1, 2], 10
        List<Integer> a = Arrays.stream(new int[] {2,3}).boxed().collect(Collectors.toList());
        List<Integer> b = Arrays.stream(new int[] {4}).boxed().collect(Collectors.toList());
        List<Integer> c = Arrays.stream(new int[] {2,3}).boxed().collect(Collectors.toList());
        List<Integer> d = Arrays.stream(new int[] {1,2}).boxed().collect(Collectors.toList());
        int actual = obj.getNumberOfOptions(a,b,c,d,10);
        int expected = 4;
        Assert.assertEquals(expected,actual);
    }
}