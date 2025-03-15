package AmazonInterview.Heap;

import java.util.PriorityQueue;

public class TotalCostHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> first = new PriorityQueue<>();  // Min-heap for left side
        PriorityQueue<Integer> last = new PriorityQueue<>();   // Min-heap for right side

        int n = costs.length;
        int left = 0;  // Left boundary for the first heap
        int right = n - 1;  // Right boundary for the last heap

        // Fill the left heap with the first 'candidates' elements
        for (; left < candidates; left++) {
            first.offer(costs[left]);
        }

        // Fill the right heap with the last 'candidates' elements (only if they don't overlap with the left)
        for (; right >= Math.max(n - candidates, left); right--) {
            last.offer(costs[right]);
        }

        long ans = 0;

        // Process 'k' workers
        for (int i = 0; i < k; i++) {
            if (!first.isEmpty() && (last.isEmpty() || first.peek() <= last.peek())) {
                ans += first.poll();
                if (left <= right) {
                    first.offer(costs[left]);
                    left++;
                }
            } else {
                ans += last.poll();
                if (right >= left) {
                    last.offer(costs[right]);
                    right--;
                }
            }
        }

        return ans;
    }
}
