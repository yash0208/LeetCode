package AmazonInterview.CountSmaller;

import java.util.Arrays;

public class CountSmallerThanSelf {
    public int[] smaller(int[] nums){
        int[] indexArr = new int[101];
        // Count occurrences of each number
        for (int num : nums) {
            indexArr[num]++;
        }
        for (int i = 1; i < indexArr.length; i++) {
            indexArr[i] = indexArr[i] + indexArr[i-1];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] == 0 ? 0 : indexArr[nums[i] - 1];
        }
        return ans;
    }
}
