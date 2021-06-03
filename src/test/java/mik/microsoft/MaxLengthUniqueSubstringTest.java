package mik.microsoft;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MaxLengthUniqueSubstringTest {
    MaxLengthUniqueSubstring obj = new MaxLengthUniqueSubstring();
    @Test
    void testMaxLength_with_input_set1() {
        int expected = 4;
        int actual = obj.maxLength(Arrays.asList("un","iq","ue"));
        Assert.assertEquals(expected,actual);
    }
    @Test
    void testMaxLength_with_input_set2() {
        int expected = 6;
        int actual = obj.maxLength(Arrays.asList("cha","r","act","ers"));
        Assert.assertEquals(expected,actual);
    }
}