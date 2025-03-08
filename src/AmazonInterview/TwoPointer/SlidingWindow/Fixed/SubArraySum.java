package AmazonInterview.TwoPointer.SlidingWindow.Fixed;

public class SubArraySum {
    public long maximumSubarraySum(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int ans = Integer.MIN_VALUE;

// Calculate the sum of the first window of size k
        while (j < k) {
            sum += nums[j];
            j++;
        }

        ans = sum; // Initialize the answer with the first window sum

// Slide the window through the rest of the array
        while (j < nums.length) {
            sum += nums[j]; // Add the new element
            sum -= nums[i]; // Remove the old element from the window
            ans = Math.max(ans, sum); // Update the answer with the maximum sum
            i++; // Move the window forward
            j++;
        }

        return ans;
    }
}
