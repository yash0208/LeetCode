package SlidingWindow;

/**
 * Ans, i ,j =0 to start
 * go till j==len
 * if num[j]==0 add zeroes
 * if zeroes=1 check if nums[i]=0 then decrement 0 or in both case increment i
 * check ans
 * return ans-1
 */
public class longestSubarrayAfterDeletionOfOneZero {
    public static int longestSubarray(int[] nums) {
        int ans = 0;
        int i = 0, j = 0;
        int zeros = 0;
        int len = nums.length;

        while (j < len) {
            if (nums[j] == 0) {
                zeros++;
            }

            while (zeros > 1) {
                if (nums[i] == 0) {
                    zeros--;
                }
                i++;
            }

            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans-1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(longestSubarray(nums));  // Output should be 6
    }
}
