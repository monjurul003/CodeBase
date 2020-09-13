package mik.randomques;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestLinkedListRelated {
    @Test
    public void testLlReverse(){
        LinkedListRelated linkedListRelated = new LinkedListRelated();
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list2.add(5);
        list2.add(4);
        list2.add(3);
        list2.add(2);
        list2.add(1);

        linkedListRelated.reverseLinkedList(list);



    }
}
