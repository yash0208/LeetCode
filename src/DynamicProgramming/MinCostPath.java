package DynamicProgramming;

public class MinCostPath {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {2, 3, 5}, {5, 3, 6}};
        System.out.print(find_cost(matrix));
    }

    static int find_cost(int[][] matrix) {
        return cost(0, 0, matrix);
    }

    static int cost(int i, int j, int[][] matrix) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;

        // Base case: bottom-right corner
        if (i == m && j == n) {
            return matrix[i][j];
        }

        // If we are at the last row, we can only move right
        if (i == m) {
            return matrix[i][j] + cost(i, j + 1, matrix);
        }

        // If we are at the last column, we can only move down
        if (j == n) {
            return matrix[i][j] + cost(i + 1, j, matrix);
        }

        // Else, we move to the right or down, whichever has a lower cost
        return matrix[i][j] + Math.min(cost(i, j + 1, matrix), cost(i + 1, j, matrix));
    }
}
