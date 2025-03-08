package AmazonInterview.TwoPointer.PrefixSum;

import java.util.HashMap;

public class SubArraySum {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Base case: one way to get sum=0

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num; // Current prefix sum

            // Check if a previous sum exists such that (sum - k) was seen before
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }

            // Store/update prefix sum frequency
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
