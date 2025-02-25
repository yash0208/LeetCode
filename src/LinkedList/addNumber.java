package LinkedList;

import java.util.List;

public class addNumber {
    public ListNode reverse(ListNode head){
        if(head.next == null) return head;
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next; // Save next node
            current.next = previous; // Reverse the link
            previous = current; // Move previous forward
            current = next; // Move current forward
        }
        return previous;
    }

    public static void printList(ListNode head1){
        ListNode head = head1;
        while (head.next!=null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        ListNode dummy = new ListNode(0);  // Dummy node to simplify result list
        ListNode ans = dummy;

        // Sum both lists while they have values
        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum = sum % 10;

            ans.next = new ListNode(sum);
            ans = ans.next;
        }

        // Reverse the result back to the correct order
        return dummy.next;
    }

}
