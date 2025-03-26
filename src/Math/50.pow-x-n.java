/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        // Handle negative exponent properly
        if (n == 0) return 1.0;
        if (n < 0) {
            x = 1 / x;
            // To prevent integer overflow when n = Integer.MIN_VALUE
            return (n == Integer.MIN_VALUE) ? x * myPow(x, -(n + 1)) : myPow(x, -n);
        }
        
        // Compute half power to avoid redundant calls
        double half = myPow(x, n / 2);
        
        // If n is even, result is half * half; if odd, multiply by x
        return (n % 2 == 0) ? half * half : half * half * x;
    }
}
// @lc code=end

