package SlidingWindow;
/**
 * Approach:
 * First take i and j at starting index
 * Now J will be the end of window, so it should go till the length
 * we will keep storing the sum for window
 * when we hit the window size we will check sum max also we need to remove value of ith index from the sum and increment i to move window ahead
 * return sum
 */
public class MaxAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        int i=0,j=0;
        double ans=Integer.MIN_VALUE;
        double sum=0;
        while(j<nums.length){
            sum=sum+nums[j];
            if(j-i+1==k){
                ans=Math.max(sum,ans);
                sum=sum-nums[i];
                i++;
            }
            j++;
        }
        return (ans/k);
    }
}


