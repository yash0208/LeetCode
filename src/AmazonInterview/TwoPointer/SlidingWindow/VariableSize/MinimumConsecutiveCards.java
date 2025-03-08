package AmazonInterview.TwoPointer.SlidingWindow.VariableSize;

import java.util.HashSet;

public class MinimumConsecutiveCards {
    public int minimumCardPickup(int[] cards) {
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        int minLen = Integer.MAX_VALUE;
        for (int j = 0; j < cards.length; j++) {
            while (set.contains(cards[j])){
                minLen = Math.min(minLen,j-i+1);
                set.remove(cards[i]);
                i++;
            }
            set.add(cards[j]);
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
