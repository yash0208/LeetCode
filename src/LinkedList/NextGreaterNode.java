package LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNode {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode temp = head;

        // Convert LinkedList to ArrayList
        while (temp != null) {
            values.add(temp.val);
            temp = temp.next;
        }

        int n = values.size();
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stack stores indices

        // Traverse the array
        for (int i = 0; i < n; i++) {
            // While stack is not empty and current value is greater than stack top
            while (!stack.isEmpty() && values.get(i) > values.get(stack.peek())) {
                ans[stack.pop()] = values.get(i); // Update result
            }
            stack.push(i); // Push current index onto stack
        }

        // Remaining indices in stack have no greater element, default 0.
        return ans;
    }
}
