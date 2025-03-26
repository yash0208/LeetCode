/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> answerList = new ArrayList<>();

        for (int i = 0; i < rowIndex + 1; i++) {
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
        return answerList.get(rowIndex);
    }
}
// @lc code=end

