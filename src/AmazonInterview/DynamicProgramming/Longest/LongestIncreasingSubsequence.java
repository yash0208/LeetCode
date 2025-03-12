package AmazonInterview.DynamicProgramming.Longest;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1]; // Memoization table
        for (int[] row : dp) Arrays.fill(row, -1); // Initialize with -1
        return dp(nums, -1, 0, dp);
    }

    public int dp(int[] nums, int prevIndex, int pointer, int[][] dp) {
        if (pointer == nums.length) return 0; // Base case: end of array

        // Memoization check
        if (dp[prevIndex + 1][pointer] != -1) return dp[prevIndex + 1][pointer];

        int taken = 0;
        if (prevIndex == -1 || nums[pointer] > nums[prevIndex]) {
            taken = 1 + dp(nums, pointer, pointer + 1, dp); // Include current element
        }

        int notTaken = dp(nums, prevIndex, pointer + 1, dp); // Exclude current element

        // Store and return the maximum result
        return dp[prevIndex + 1][pointer] = Math.max(taken, notTaken);
    }
}
