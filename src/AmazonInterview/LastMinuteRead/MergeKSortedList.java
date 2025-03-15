package AmazonInterview.LastMinuteRead;

import LinkedList.ListNode;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        //Here all the nodes needs to be in a sorted order
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)-> a.val - b.val);
        for(ListNode listNode: lists) {
            if(listNode != null) queue.add(listNode);
        }
        ListNode result = new ListNode(-1);
        ListNode pointer = result;
        while (!queue.isEmpty()){
            ListNode current = queue.poll();
            if(current == null) continue;
            pointer.next = current;
            pointer = pointer.next;
            ListNode newNode = current.next;
            if(newNode != null)queue.add(newNode);
        }
        return result.next;
    }
}
