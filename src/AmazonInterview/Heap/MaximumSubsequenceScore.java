package AmazonInterview.Heap;

import java.util.PriorityQueue;

public class MaximumSubsequenceScore {
    class Pair{
        int player;
        int score;

        public Pair(int player,int score){
            this.player = player;
            this.score = score;
        }
    }
    public long maxScore(int[] nums1, int[] nums2, int k) {
        Pair[] pairs = new Pair[nums1.length];
        for(int i = 0;i<nums1.length;i++){
            pairs[i] = new Pair(nums1[i],nums2[i]);
        }
        PriorityQueue<Pair> pairQueue = new PriorityQueue<>((a,b) -> b.score - a.score);
        int max = 0;
        int score = 0;
        for (int i = 0; i < pairs.length; i++) {
            pairQueue.add(pairs[i]);
            score = score + pairs[i].player;
            if(pairQueue.size() > k){
                Pair pair = pairQueue.poll();
                score = score - pair.player;
            }
            if(pairQueue.size() == k){
                int currentMax = score * pairQueue.peek().score;
                max = Math.max(max,currentMax);
            }
        }
        return max;
    }
}
