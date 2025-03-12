package Matrix;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MatrixCellDistance {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] ans = new int[rows * cols][2];
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{rCenter, cCenter});
        visited[rCenter][cCenter] = true;

        int index = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            ans[index++] = cell;

            for (int[] d : directions) {
                int newRow = cell[0] + d[0];
                int newCol = cell[1] + d[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]) {
                    queue.add(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
        return ans;
    }
}
