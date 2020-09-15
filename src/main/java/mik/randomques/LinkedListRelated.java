package mik.randomques;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Stack;

public class LinkedListRelated {

    public void reverseLinkedList(List<Integer> list){
        Stack<Integer> stack = new Stack<Integer>();
        while(list.size()>0) {
            stack.push(list.remove(0));
        }
        while(!stack.isEmpty()) {
            list.add((stack.pop()));
        }

    }
    public void removeDuplicates(List<Integer> list){
        if(list == null) {
            return;
        }
        LinkedHashSet<Integer> listSet = new LinkedHashSet<>();
        listSet.addAll(list);
        list.clear();
        list.addAll(listSet);
    }

}
