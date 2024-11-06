package SlidingWindow;

/**
 * Ans, i ,j =0 to start
 * go till j==len
 * if num[j]==0 add zeroes
 * if zeroes=k check if nums[i]=0 then decrement 0 or in both case increment i
 * check ans
 * return ans
 */
public class longestOnes {
    public static int longestOnes(int[] nums, int k) {
        int ans = 0;
        int i = 0, j = 0;
        int zeros = 0;
        int len = nums.length;

        while (j < len) {
            if (nums[j] == 0) {
                zeros++;
            }

            while (zeros > k) {
                if (nums[i] == 0) {
                    zeros--;
                }
                i++;
            }

            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums, k));  // Output should be 6
    }
}
