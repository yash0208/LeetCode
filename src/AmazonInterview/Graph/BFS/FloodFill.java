package AmazonInterview.Graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    int[] xDirection = {-1, 0, 1, 0};
    int[] yDirection = {0, 1, 0, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int width = image[0].length;
        int height = image.length;
        int sourceColor = image[sr][sc];

        // If the source color is the same as the target color, no need to do anything
        if (sourceColor == color) {
            return image;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = color;  // Fill the starting pixel immediately

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int j = 0; j < xDirection.length; j++) {
                int x = currentX + xDirection[j];
                int y = currentY + yDirection[j];

                // Check bounds and sourceColor to perform the flood fill
                if (x >= 0 && y >= 0 && x < height && y < width && image[x][y] == sourceColor) {
                    image[x][y] = color;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return image;
    }
}
