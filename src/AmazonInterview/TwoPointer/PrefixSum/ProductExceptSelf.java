package AmazonInterview.TwoPointer.PrefixSum;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];


        // Compute prefix products
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Compute suffix products
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            prefix[i] = prefix[i] * suffix;
            suffix = suffix * nums[i];
        }

        return prefix;
    }

}
