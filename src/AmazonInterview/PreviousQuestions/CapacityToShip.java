package AmazonInterview.PreviousQuestions;

import java.util.Arrays;

public class CapacityToShip {
    public int shipWithinDays(int[] weights, int days) {
        //what we can do is we can guess the wieght in the date range with the binary search and use that weight to count the days
        int totalWeight = Arrays.stream(weights).sum();
        int left = 0;
        int right = totalWeight;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(daysCount(weights,mid) <= days) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    int daysCount(int[] weight,int cap){
        int count = 0;
        int sum = 0;
        for (int i = 0; i < weight.length; i++) {
            if(sum > cap){
                count++;
                sum = 0;
            }
            sum = sum + weight[i];
        }
        return count;
    }
}
