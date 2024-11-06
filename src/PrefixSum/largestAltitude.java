package PrefixSum;

/**
 * take ans and sum
 * initialize sum as 0 because we need to start from ground level
 * keep updating sum and ans
 * return ans
 */
public class largestAltitude {
    public int largestAltitude(int[] gain) {
        int ans = 0; // Start at sea level, which is 0
        int sum = 0; // Starting altitude is 0
        for (int i = 0; i < gain.length; i++) {
            sum += gain[i]; // Cumulative sum of gains
            ans = Math.max(ans, sum); // Update the maximum altitude
        }
        return ans;
    }
}
