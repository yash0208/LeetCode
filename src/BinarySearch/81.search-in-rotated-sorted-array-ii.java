package BinarySearch;
/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        // we want to find the target in the rotated sorted array
        // we can use binary search to find the target
        // we can use the same approach as in the rotated sorted array
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return true;
            // now we have to think all test cases
            // lets think when mid is same as right 
            // 
            if( nums[mid] == nums [right]) right --;
            // lets see if the left is sorted
            else if ( nums[left] < nums[mid] ){
                // if so there can be 2 cases 
                // number is in left 
                if(target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            }
            // else the right part is sorted
            else { 
                if (nums[mid] < target && target <= nums[right]) 
                    left = mid + 1;
                else 
                    right = mid - 1;
            }
        }

        return false;
    }
}
// @lc code=end

