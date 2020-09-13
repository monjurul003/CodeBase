package mik.bitquill;

import org.junit.Assert;
import org.junit.Test;

public class TestCircularQueue {
    @Test
    public void testPeek() throws Exception {
        CircularQueue q = new CircularQueue(5);
        q.enqueue(1);
        Assert.assertEquals(1,q.peek());
    }
    
}
