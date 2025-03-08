package AmazonInterview.TwoPointer.TeleporterArrays;

public class TeleporterArray {
    public int maxSum(int[] arr1, int[] arr2) {
        final int MOD = 1_000_000_007;
        int i = 0, j = 0;
        long sum1 = 0, sum2 = 0;

        while (i < arr1.length || j < arr2.length) {
            if (i < arr1.length && (j == arr2.length || arr1[i] < arr2[j])) {
                sum1 += arr1[i++];
            } else if (j < arr2.length && (i == arr1.length || arr2[j] < arr1[i])) {
                sum2 += arr2[j++];
            } else { // arr1[i] == arr2[j]
                long bestSum = Math.max(sum1, sum2) + arr1[i];
                sum1 = sum2 = bestSum; // Reset both sums to bestSum
                i++;
                j++;
            }
        }
        return (int) (Math.max(sum1, sum2) % MOD);
    }
}
