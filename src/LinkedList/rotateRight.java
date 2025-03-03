package LinkedList;

import java.util.List;

public class rotateRight {
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null || k == 0) return head; // Handle edge cases

            // Find the length of the list
            ListNode current = head;
            int length = 1;
            while (current.next != null) {
                current = current.next;
                length++;
            }

            // Adjust k if it's greater than the length of the list
            k = k % length;
            if (k == 0) return head; // No rotation needed

            // Find the new tail (length - k - 1) and new head (length - k)
            ListNode slow = head;
            for (int i = 1; i < length - k; i++) {
                slow = slow.next;
            }

            // Set new head and break the list
            ListNode newHead = slow.next;
            slow.next = null;
            current.next = head; // Connect old tail to old head

            return newHead;
        }
    }

}
