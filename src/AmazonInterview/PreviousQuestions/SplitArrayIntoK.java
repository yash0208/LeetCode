package AmazonInterview.PreviousQuestions;

import java.util.Arrays;

public class SplitArrayIntoK {
    public int splitArray(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int total = Arrays.stream(nums).sum();
        int left = max;
        int right = total;
        while (left < right){
            int mid = left + (right - left) / 2;
            //we can visualize that this mid can be a sum using which we can divide array into k partitions
            if(partitionsCounter(nums,mid) <= k) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    int partitionsCounter(int[] nums,int cap){
        int count = 1;
        int sum = 0;
        for (int num : nums){
            if(sum + num > cap){
                count ++;
                sum = 0;
            }
            sum = sum + num;
        }
        return count;
    }
}
