package mik.bitquill;

public class CircularQueue implements SimpleQueue{
    private int[] queue;
    private int head;
    private int tail;
    private int capacity;
    private int size;

    public CircularQueue(int cap) {
        capacity = cap;
        queue = new int[capacity];
        head = 0;
        tail = -1;
        size = 0;
    }

    @Override
    public boolean isFull() {
        return capacity == size;
    }

    @Override
    public boolean enqueue(int value) {
        if(size == capacity) {
            return false;
        }
        queue[++tail%capacity] = value;
        size++;
        return true;
    }

    @Override
    public int dequeue() throws Exception {
        if(size == 0){
            throw new Exception();
        }
        int result = queue[head];
        head = (head+1) % capacity;
        size--;
        return result;
    }
    public int peek() throws Exception {
        if(size == 0){
            throw new Exception();
        }
        return queue[head];
    }
    @Override
    public int getCapacity() {
        return capacity;
    }
    public int getSize() {
        return size;
    }
    public void printQueue() {
        for (int i = 0; i < queue.length; i++) {
            System.out.print(queue[i]+ " ");
        }
        System.out.println();
    }
}
