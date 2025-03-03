package SlidingWindow.FixedSize;

public class MaximumAverage {
    public double findMaxAverage(int[] nums, int k) {
        double ans = Double.NEGATIVE_INFINITY; // Use Double.NEGATIVE_INFINITY for comparison
        int i = 0;
        double sum = 0.0;

        // Initialize the first 'k' elements
        for (int j = 0; j < k; j++) {
            sum += nums[j];
        }
        ans = sum / k;

        // Use sliding window approach
        for (int j = k; j < nums.length; j++) {
            sum += nums[j];    // Add new element
            sum -= nums[i];    // Remove the leftmost element
            i++;
            ans = Math.max(ans, sum / k);
        }

        return ans;
    }

}
