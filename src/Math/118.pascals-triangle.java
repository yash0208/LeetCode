/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answerList = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // First and last elements in a row are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Compute sum of two values from the previous row
                    int val = answerList.get(i - 1).get(j - 1) + answerList.get(i - 1).get(j);
                    row.add(val);
                }
            }
            answerList.add(row);
        }
        return answerList;
    
    }   
}
// @lc code=end

