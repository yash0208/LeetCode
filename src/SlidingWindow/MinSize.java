package SlidingWindow;

public class MinSize {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int minLen = Integer.MAX_VALUE;
        int i = 0, sum = 0;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];  // Expand the window

            while (sum >= target) {  // Shrink the window when valid
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i];  // Remove the leftmost element
                i++;  // Move left pointer forward
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
