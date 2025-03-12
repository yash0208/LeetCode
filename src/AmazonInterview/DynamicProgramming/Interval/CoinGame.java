package AmazonInterview.DynamicProgramming.Interval;

import java.util.Arrays;

import java.util.HashMap;
import java.util.Map;

class CoinGame {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int numSquares(int n) {
        if (n == 0) return 0; // Base case
        if (memo.containsKey(n)) return memo.get(n); // Use memoized result

        int minCount = Integer.MAX_VALUE;
        for (int j = 1; j * j <= n; j++) {
            minCount = Math.min(minCount, 1 + numSquares(n - j * j));
        }

        memo.put(n, minCount); // Store result in memo
        return minCount;
    }
}

