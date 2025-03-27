package BinarySearch;
/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)) end = mid - 1;
            else start = mid + 1; 
            }
       return start;     
    }
}
// @lc code=end

