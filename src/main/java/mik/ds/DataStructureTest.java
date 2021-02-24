package mik.ds;

import java.util.*;
import java.util.stream.Collectors;

public class DataStructureTest {
    public static void stackTest() {
        Stack<String> stack = new Stack<String>();
        stack.push("asd");
        stack.push("sdw");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.search("sdw"));

        //1. iterate simple
        for (String str : stack) {
            System.out.println(str);
        }
        //2. iterate sample 2
        Iterator itr = stack.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        //empty stack
        stack.clear();
        //reverse a linked list using stack

        List<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        while (list.size() > 0) {
            stack.push(list.remove(0));
        }
        while (stack.size() > 0) {
            list.add(stack.pop());
        }
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void queueTest() {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1); // add element when q is full throw error
        q.offer(4); // add element when q is full return false
        System.out.println(q.peek()); //see the first element
        System.out.println(q.poll()); //remove and return first element
        System.out.println(q.remove()); //remove and return first element
    }

    public static void testPriorityQueue() {
        //priority queue based on descending order int list
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, Collections.reverseOrder());
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(5);
        System.out.println(pq.peek()); //print 5

        //priority queue based on ascending order int list
        pq = new PriorityQueue<Integer>();
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(5);
        System.out.println(pq.peek());

        //get lexicographically sorted ascending order list
        PriorityQueue<String> pq1;
        pq1 = new PriorityQueue<String>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        pq1.add("bsd");
        pq1.add("asd");
        System.out.println(pq1.remove());

        //get lexicographically sorted descending order list
        PriorityQueue<String> pq2;
        pq2 = new PriorityQueue<String>(100, (s1,s2)-> s2.compareTo(s1));
        pq2.add("bsd");
        pq2.add("asd");
        System.out.println(pq2.remove());

        //get smallest string first
        pq2 = new PriorityQueue<>(100, (s1,s2) -> s1.length()-s2.length());
        pq2.add("bs");
        pq2.add("asd");
        System.out.println(pq2.remove());
    }

    public static void testHashMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("asd", 1);
        map.putIfAbsent("qwe", 2);

        System.out.println(map.getOrDefault("as", 0));
        //iterate over hashmap
        for (String s : map.keySet()) {
            System.out.println(s + "- " + map.get(s));
        }
        Iterator<String> itr = map.keySet().iterator();
        while (itr.hasNext()) {
            String key = itr.next();
            System.out.println(key + "- " + map.get(key));
        }

    }


    public void testArraylList(){
        //int[] -> List<Integer>
        List<Integer> list = Arrays.stream(new int[] {2,4,1,3,5,6,7}).boxed().collect(Collectors.toList());
        // List<Integer> -> int[]
        int[] arr = list.stream().mapToInt(i->i).toArray();



    }
    public static void main(String[] args) {
        testPriorityQueue();
        testHashMap();
    }

}
