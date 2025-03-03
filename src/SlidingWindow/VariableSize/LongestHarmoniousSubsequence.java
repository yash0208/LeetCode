package SlidingWindow.VariableSize;

import java.util.Arrays;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        int dif=0,max_len=0;
        Arrays.sort(nums);
        int s=0,e=1;
        while(e<nums.length){
            while(nums[e]-nums[s]>1)
                s++;
            if(nums[e]-nums[s]==1){
                max_len=Math.max(max_len,e-s+1);
            }
            e++;
        }
        return max_len;
    }
}
