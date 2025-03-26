/*
 * @lc app=leetcode id=3492 lang=java
 *
 * [3492] Maximum Containers on a Ship
 */

// @lc code=start
class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        // here we need to find the maximum number of containers that can be bought
        // n = matrix size
        // which means total number of containers are n * n
        int totalContainers = n * n;
        // we can divide the total weigth with w to find out max what we can include 
        int maxContainers = maxWeight / w;
        // we need to return the minimum of the two
        System.out.println("totalContainers: " + totalContainers + " maxContainers: " + maxContainers);
        return Math.min(totalContainers, maxContainers);
    }
}
// @lc code=end

