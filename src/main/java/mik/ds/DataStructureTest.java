package mik.ds;

import java.util.*;

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
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, Collections.reverseOrder());
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(5);
        System.out.println(pq.peek());

        PriorityQueue<String> pq1;
        pq1 = new PriorityQueue<String>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        pq1.add("bsd");
        pq1.add("asd");
        System.out.println(pq1.remove());
    }

    public static void testHashMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("asd", 1);
        map.put("qwe", 2);
        for (String s : map.keySet()) {
            System.out.println(s + "- " + map.get(s));
        }
        Iterator<String> itr = map.keySet().iterator();
        while (itr.hasNext()) {
            String key = itr.next();
            System.out.println(key + "- " + map.get(key));
        }

    }

    public static void main(String[] args) {
        testPriorityQueue();
        testHashMap();
    }

}
