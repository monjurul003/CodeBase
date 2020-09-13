package mik.bitquill;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    final Node head = new Node();
    final Node tail = new Node();
    int cap;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<Integer, Node>(cap);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int result = -1;
        if(map.containsKey(key)) {
            Node node = map.get(key);
            result = node.val;
            remove(node);
            add(node);
        }
        return result;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null) {
            remove(node);
            node.val = value;
            add(node);
        } else {
            if(map.size() == cap) {
                Node old = tail.prev;
                map.remove(old.key);
                remove(old);
            }
            node = new Node();
            node.val = value;
            node.key = key;
            add(node);
            map.put(key, node);
        }
    }
    public void add(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }
    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
