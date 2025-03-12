package AmazonInterview.DynamicProgramming.Knapsack;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount+1];
        Arrays.fill(arr,-1);
        int result = helper(coins, amount,arr);

        return result == Integer.MAX_VALUE ? -1 : result; // Handle unreachable cases
    }

    private int helper(int[] coins, int remaining,int[] arr) {
        if (remaining == 0) return 0; // Base case: exact change achieved
        if (remaining < 0) return Integer.MAX_VALUE; // Invalid case
        if(arr[remaining] != -1) return arr[remaining];
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, remaining - coin,arr);
            if (res != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + res);
            }
        }
        return arr[remaining] = minCoins;
    }
}
