package LinkedList;

import java.util.List;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
         val = x;
          next = null;
      }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

