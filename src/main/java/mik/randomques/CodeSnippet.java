package mik.randomques;

import java.security.CodeSource;
import java.util.PriorityQueue;
import java.util.Queue;

public class CodeSnippet {
    public int getLastPoint(int[] nums, int target){
        System.out.println("Last:: ");
        int l = 0, r = nums.length-1, index = -1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            System.out.print(mid + ", ");
            if(nums[mid] <= target) {
                l = mid+1;
            } else{
                r = mid-1;
            }
            if(nums[mid]==target){
                index = mid;
            }
        }
        return index;
    }
    public int getFirstPoint(int[] nums, int target){
        int l = 0, r = nums.length-1, index = -1;
        System.out.println("first: ");
        while(l < r) {
            int mid = l + (r-l)/2;
           // System.out.print(mid + ", ");
            if(nums[mid] >= target) {
                r = mid-1;
            } else{
                l = mid+1;
            }
            if(nums[mid]==target){
                index = mid;
                System.out.print(mid + ", ");
                while(nums[++mid] == target){
                    System.out.print(mid + ", ");
                }
            }
        }
        return index;
    }
    public void testPq(){
        Queue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        pq.offer(5);
        pq.offer(1);
        pq.offer(2);
        pq.offer(6);
        while(!pq.isEmpty()){
            System.out.print(pq.poll() + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        CodeSnippet cs = new CodeSnippet();
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        System.out.println(cs.getFirstPoint(nums,target));
        System.out.println(cs.getLastPoint(nums,target));

    }
}
