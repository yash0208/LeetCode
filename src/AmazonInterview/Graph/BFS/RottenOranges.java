package AmazonInterview.Graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    int[] xDirection = {-1,0,1,0};
    int[] yDirection = {0,1,0,-1};
    public int orangesRotting(int[][] grid) {
        int size = grid.length;
        int length = grid[0].length;
        Queue<int[]> rottenOranges = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 2) rottenOranges.add(new int[]{i,j});
            }
        }
        int days = 0;
        while (!rottenOranges.isEmpty()){
            int levelSize = rottenOranges.size();
            boolean flag = false;
            for (int i = 0; i < levelSize; i++) {
                int[] currentCell = rottenOranges.poll();
                for (int k = 0; k < xDirection.length; k++) {
                    int x = currentCell[0] + xDirection[k];
                    int y = currentCell[1] + yDirection[k];
                    if(x>=0 && y>=0 && x<size && y<length && grid[x][y] == 1){
                        grid[x][y] = 2;
                        flag = true;
                        rottenOranges.add(new int[]{x,y});
                    }
                }
            }
            if(flag) days++;
        }
        //check
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j< grid[i].length; j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        return days;
    }
}
