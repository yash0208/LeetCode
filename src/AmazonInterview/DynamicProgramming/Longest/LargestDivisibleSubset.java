package AmazonInterview.DynamicProgramming.Longest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums); // Step 1: Sort the array
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] stores the length of the largest subset ending at index i
        int[] prev = new int[n]; // prev[i] stores the previous index in the subset
        Arrays.fill(dp, 1); // Every number alone is a valid subset
        Arrays.fill(prev, -1);

        int maxSize = 0, maxIndex = -1;

        // Step 2: Populate DP table
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j; // Track the last index used
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        // Step 3: Backtrack to reconstruct the subset
        List<Integer> result = new ArrayList<>();
        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }

        Collections.reverse(result); // Since we backtracked, reverse to get the correct order
        return result;
    }
}
