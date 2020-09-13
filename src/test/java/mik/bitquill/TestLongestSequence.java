package mik.bitquill;

import org.junit.Assert;
import org.junit.Test;

public class TestLongestSequence {
    @Test
    public void testLongestSequenceWithInput1(){
        LongestMatchSet obj = new LongestMatchSet();
        int a = obj.getLongest("(1[234)567]");
        Assert.assertEquals(9,a);
    }
    @Test
    public void testWithInput2() {
        LongestMatchSet longestMatchSet = new LongestMatchSet();
        int a = longestMatchSet.getLongest("()");
        Assert.assertEquals(2,a);

    }

    @Test
    public void testWithLongInput() {
        LongestMatchSet longestMatchSet = new LongestMatchSet();
        int a = longestMatchSet.getLongest("[1234567][1234567890]");
        Assert.assertEquals(12,a);

    }
}
