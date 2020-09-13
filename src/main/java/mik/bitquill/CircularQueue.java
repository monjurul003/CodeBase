package mik.bitquill;

public class CircularQueue implements SimpleQueue{
    private int[] queue;
    private int head;
    private int tail;
    private int capacity;
    private int size;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.head = 0;
        this.tail = -1;
        this.size = 0;
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
        this.queue[++tail%capacity] = value;
        this.size++;
        return true;
    }

    @Override
    public int dequeue() throws Exception {
        if(this.size == 0){
            throw new Exception();
        }
        int result = this.queue[this.head];
        this.head = (this.head+1) % this.capacity;
        this.size--;
        return result;
    }
    public int peek() throws Exception {
        if(this.size == 0){
            throw new Exception();
        }
        return this.queue[this.head];
    }
    @Override
    public int getCapacity() {
        return this.capacity;
    }
    public int getSize() {
        return this.size;
    }
    public void printQueue() {
        for (int i = 0; i < this.queue.length; i++) {
            System.out.print(this.queue[i]+ " ");
        }
        System.out.println();
    }
}
