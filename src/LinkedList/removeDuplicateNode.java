package LinkedList;

public class removeDuplicateNode {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode res = new ListNode(0,head);
            ListNode prev = res;

            while(head != null && head.next != null){
                if(head.next.val == head.val){
                    while(head.next != null && head.next.val == head.val){
                        head = head.next;
                    }
                    prev.next = head.next;
                }else{
                    prev = prev.next;
                }
                head = head.next;
            }
            return res.next;
        }
    }
}
