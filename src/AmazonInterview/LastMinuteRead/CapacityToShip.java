package AmazonInterview.LastMinuteRead;

import java.util.Arrays;

public class CapacityToShip {
    public int shipWithinDays(int[] weights, int days) {
        // what we can do is we can take a number and check if we can ship or not
        int maxCap = Arrays.stream(weights).sum();
        int minCap = Arrays.stream(weights).max().getAsInt();
        while (minCap < maxCap){
            int midCap = minCap + (maxCap - minCap) / 2;
            if(daysToShip(weights,midCap) > days) minCap = midCap + 1;
            else maxCap = midCap;
        }
        return minCap;
    }
    public int daysToShip(int[] weights,int capacity){
        int days = 0;
        int tempCap = 0;
        for(int weight : weights){
            if (tempCap + weight > capacity) {
                days++; // Start a new day
                tempCap = weight; // Reset tempCap to current weight
            } else {
                tempCap += weight; // Add weight to current day's capacity
            }
        }
        return tempCap;
    }
}
