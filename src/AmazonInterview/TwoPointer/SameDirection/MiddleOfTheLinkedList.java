package AmazonInterview.TwoPointer.SameDirection;


import java.util.List;

class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next !=null && slow.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
