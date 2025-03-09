package AmazonInterview.BinarySearch;

import java.util.Arrays;

public class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;  // Minimum eating speed
        int right = Arrays.stream(piles).max().getAsInt();  // Maximum pile size

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEat(piles, h, mid) <= h) right = mid;  // Check if speed `mid` is feasible
            else left = mid + 1;
        }
        return left;
    }

    private int canEat(int[] piles, int hours, int k) {
        int h = 0;
        for (int pile : piles) {
            h += (pile + k - 1) / k;  // Equivalent to Math.ceil((double) pile / k)
        }
        return h;
    }
}
