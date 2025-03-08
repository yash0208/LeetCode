package AmazonInterview.TwoPointer.PrefixSum;

import java.util.Arrays;

class NumArray {
    int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length + 1];  // Extra element for handling sums from index 0
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        // The prefixSum array is 1-indexed for easier sum calculation
        return prefixSum[right + 1] - prefixSum[left];
    }


}
