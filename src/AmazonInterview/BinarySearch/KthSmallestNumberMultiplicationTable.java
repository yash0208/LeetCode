package AmazonInterview.BinarySearch;

public class KthSmallestNumberMultiplicationTable {
    public int findKthNumber(int m, int n, int k) {
        int left = 0, right = m * n;
        while (left < right) {
            int count = 0;

            int mid = left + (right - left) / 2;
            for (int i = 1; i <= m; i++) {
                count += (n < mid / i ? n : (mid / i));
            }

            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
