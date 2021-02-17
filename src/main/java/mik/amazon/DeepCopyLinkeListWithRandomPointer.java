package mik.amazon;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class DeepCopyLinkeListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) return head;

        Node src = head;

        while (src != null) {
            Node copy = new Node(src.val);
            copy.next = src.next;
            src.next = copy;
            src = copy.next;
        }
        src = head;
        while (src != null && src.next != null) {
            Node cur = src.next;
            if (src.random != null) {
                cur.random = src.random.next;
            }
            src = src.next.next;
        }

        Queue<Node> q = new LinkedList();
        src = head;
        while (src != null && src.next != null) {
            q.offer(src.next);
            src.next = src.next.next;
            src = src.next;
        }
        Node copy = q.peek();
        while (!q.isEmpty()) {
            src = q.poll();
            src.next = q.peek();
        }

        return copy;
    }

}
