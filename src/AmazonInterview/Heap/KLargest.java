package AmazonInterview.Heap;

import java.util.PriorityQueue;

public class KLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if(queue.size() > k) queue.poll();
        }
        System.out.println(queue.toString());
        return queue.peek();
    }
}
