package mik.bitquill;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class TestCircularQueue {
    @Test
    @DisplayName("Test Enqueue Operation")
    public void testSuccessfulEnqueue() throws Exception {
        CircularQueue q = new CircularQueue(5);
        Assert.assertTrue(q.enqueue(1));
    }
    @Test
    public void testFailedEnqueue() throws Exception {
        CircularQueue q = new CircularQueue(1);
        q.enqueue(2);
        Assert.assertFalse(q.enqueue(1));
    }
    @Test
    public void testPeek() throws Exception {
        CircularQueue q = new CircularQueue(5);
        q.enqueue(1);
        Assert.assertEquals(1,q.peek());
    }
    @Test
    public void testCapacity() throws Exception {
        CircularQueue circularQueue = new CircularQueue(2);
        Assert.assertEquals(2,circularQueue.getCapacity());
    }
    @Test
    public void testisFull() throws Exception {
        CircularQueue circularQueue = new CircularQueue(2);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        Assert.assertTrue("Circular queue is full.", circularQueue.isFull());
    }
}
