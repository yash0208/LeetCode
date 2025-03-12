package AmazonInterview.PreviousQuestions;

public class MinSwaps {
    public int minimumSwaps(int[] nums) {
        int n = nums.length; // Length of the given array
        int minIndex = 0, maxIndex = 0; // Initialize indices for minimum and maximum elements

        // Loop through the array to find the indices for the minimum and maximum elements
        for (int k = 0; k < n; ++k) {
            // Update the index of the minimum element found so far
            if (nums[k] < nums[minIndex] || (nums[k] == nums[minIndex] && k < minIndex)) {
                minIndex = k;
            }
            // Update the index of the maximum element found so far
            if (nums[k] > nums[maxIndex] || (nums[k] == nums[maxIndex] && k > maxIndex)) {
                maxIndex = k;
            }
        }

        // If the minimum and maximum elements are at the same position, no swaps are needed
        if (minIndex == maxIndex) {
            return 0;
        }

        // Calculate the number of swaps required
        // The calculation is done by considering the positions of the minimum and maximum elements
        // and adjusting the swap count depending on their relative positions
        int swaps = minIndex + n - 1 - maxIndex - (minIndex > maxIndex ? 1 : 0);

        // Return the number of swaps
        return swaps;
    }
}
