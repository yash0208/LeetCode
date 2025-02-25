package Matrix;

import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {

        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) return new ArrayList<>();

            int top = 0, bottom = matrix.length - 1;
            int left = 0, right = matrix[0].length - 1;
            List<Integer> ans = new ArrayList<>();

            while (top <= bottom && left <= right) {
                // Traverse from left to right
                for (int i = left; i <= right; i++) {
                    ans.add(matrix[top][i]);
                }
                top++; // Move top boundary down

                // Traverse from top to bottom
                for (int i = top; i <= bottom; i++) {
                    ans.add(matrix[i][right]);
                }
                right--; // Move right boundary left

                // Ensure there is still a row remaining
                if (top <= bottom) {
                    // Traverse from right to left
                    for (int i = right; i >= left; i--) {
                        ans.add(matrix[bottom][i]);
                    }
                    bottom--; // Move bottom boundary up
                }

                // Ensure there is still a column remaining
                if (left <= right) {
                    // Traverse from bottom to top
                    for (int i = bottom; i >= top; i--) {
                        ans.add(matrix[i][left]);
                    }
                    left++; // Move left boundary right
                }
            }
            return ans;
        }


}
