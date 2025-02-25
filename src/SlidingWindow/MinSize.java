package SlidingWindow;

public class MinSize {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0 ;
        int j = 0;
        int size = Integer.MAX_VALUE;
        int sum = 0;
        while (j<nums.length){
            sum = sum + nums[j];
            if(sum >= target) {
                size  = Math.min(size,((j-i) + 1)) ;
                i++;
            }
            j++;
        }
        return size;
    }
}
