package mik.bitquill;

public class QueueTester {
    public static void main(String[] args) throws Exception {
        CircularQueue q = new CircularQueue(5);
        for (int i = 1; i < 6; i++) {
            q.enqueue(i);
        }
        q.printQueue();
        System.out.println(q.dequeue());
        System.out.println(q.getSize());
        q.enqueue(6);
        for (int i = 1; i < 6; i++) {
            System.out.print(q.dequeue() + " ");
        }
        System.out.println();
        q.enqueue(7);
        q.printQueue();

        int[] nums = new int[] {4,3,2,7,8,2,3,1};
        int j = 0;
        for (int i = 0; i < nums.length ; i++) {
            int val = Math.abs(nums[i]) -1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                j = i+1;
                System.out.println("****" + j);
            }
        }
        for(int i: nums){
            System.out.print(i+" ");
        }
    }
}
