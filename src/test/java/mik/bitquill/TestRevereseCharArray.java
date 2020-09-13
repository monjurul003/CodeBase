package mik.bitquill;


import org.junit.Assert;
import org.junit.Test;

public class TestRevereseCharArray {
    @Test
    public void testReverseCharArrayNullValue() {
        char[] a = null;
        int b = ReverseCharArray.reverseCharAray(a);
        Assert.assertEquals(0, b);
    }

    @Test
    public void testReverseCharArrayWithEmptyArray() {
        char[] a = new char[0];
        int b = ReverseCharArray.reverseCharAray(a);
        Assert.assertEquals(0, b);
    }

    @Test
    public void testReverseWithValidInput() {
        char[] a = new char[]{'a', 'b', 'c', 'd'};
        int b = ReverseCharArray.reverseCharAray(a);
        Assert.assertEquals(1,b);
    }
    @Test
    public void testReverseWithOneElementArray() {
        char[] a = new char[]{'a'};
        int b = ReverseCharArray.reverseCharAray(a);
        Assert.assertEquals(1,b);
    }
}
