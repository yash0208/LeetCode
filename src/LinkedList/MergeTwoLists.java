package LinkedList;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0); // Dummy node for easy handling
        ListNode temp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next; // Move temp forward
        }

        // Attach the remaining part of the list (if any)
        if (list1 != null) temp.next = list1;
        if (list2 != null) temp.next = list2;

        return dummy.next; // Return merged list (excluding dummy node)
    }
}
