package AmazonInterview.TwoPointer.SlidingWindow.Fixed;

import java.util.HashSet;

public class MaxSumDistinctSubArray {
    public long maximumSubarraySum(int[] nums, int k) {
        if (nums.length < k) return 0;

        int i = 0;
        long sum = 0, maxSum = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int j = 0; j < nums.length; j++) {
            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            set.add(nums[j]);
            sum += nums[j];

            // If the window size reaches `k`, update maxSum
            if ((j - i + 1) == k) {
                maxSum = Math.max(maxSum, sum);
                // Shrink the window from the left
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
        }

        return maxSum;
    }
}
