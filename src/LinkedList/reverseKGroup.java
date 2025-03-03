package LinkedList;

import java.util.List;

public class reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head; // No need to reverse if the list is empty or k is 1

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (head != null) {
            ListNode groupStart = head;
            ListNode groupEnd = head;
            // Find the end of the group
            for (int i = 1; i < k && groupEnd != null; i++) {
                groupEnd = groupEnd.next;
            }

            // If there are not enough nodes to reverse, leave them as is
            if (groupEnd == null) break;

            // Save the next node after the group
            ListNode nextGroupStart = groupEnd.next;

            // Reverse the group
            ListNode prev = nextGroupStart;
            ListNode current = groupStart;
            while (current != nextGroupStart) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            // Connect the reversed group back to the previous part of the list
            prevGroupEnd.next = groupEnd;
            groupStart.next = nextGroupStart;

            // Move prevGroupEnd and head to the next group
            prevGroupEnd = groupStart;
            head = nextGroupStart;
        }

        return dummy.next;
    }


}
