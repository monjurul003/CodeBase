package mik.bitquill;

import org.junit.Assert;
import org.junit.Test;

public class TestCount1 {
    @Test
    public void testWithN(){
        Count1 count1 = new Count1();
        int a = count1.countDigit1(11);
        Assert.assertEquals(4,a);
    }
}
