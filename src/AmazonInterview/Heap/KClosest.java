package AmazonInterview.Heap;

import java.util.PriorityQueue;

public class KClosest {
    static class Pair {
        int x, y;
        double dist; // Store distance to avoid recomputation

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = Math.pow(x, 2) + Math.pow(y, 2);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        // Max-heap to store k closest points
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
                (a, b) -> Double.compare(b.dist, a.dist) // Max-heap based on distance
        );

        for (int[] point : points) {
            Pair p = new Pair(point[0], point[1]);
            maxHeap.add(p);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove the farthest point
            }
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            Pair p = maxHeap.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
        }

        return ans;
    }
}
    