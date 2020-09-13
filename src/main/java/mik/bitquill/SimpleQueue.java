package mik.bitquill;

public interface SimpleQueue {

    // Returns true if the queue is at its capacity.

    public boolean isFull();


    // Adds an element to the queue. Returns false if the element couldn’t be

    // added.

    public boolean enqueue(int value);


    // Returns the oldest element in the queue.

    // Throws an exception if there are no items in the queue.

    public int dequeue() throws Exception;


    // Returns the maximum number of entries in the queue.

    public int getCapacity();

}