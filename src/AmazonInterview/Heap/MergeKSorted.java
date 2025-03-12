package AmazonInterview.Heap;


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class MergeKSorted {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add only non-null lists to the priority queue
        for (ListNode list : lists) {
            if (list != null) queue.add(list);
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (!queue.isEmpty()) {
            ListNode current = queue.poll();
            temp.next = current;
            temp = temp.next;

            // Add the next node of the current list to the queue (if it exists)
            if (current.next != null) queue.add(current.next);
        }

        return dummy.next;
    }

}
