package AmazonInterview.LastMinuteRead;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfIslands {
    int[] xDirections = new int[]{-1,0,1,0};
    int[] yDirections = new int[]{0,1,0,-1};

    public int numIslands(char[][] grid) {
        // what we need to do is make all connected islands one and return total islands
        // what we can do is we can make a set of all islands visited and make bfs on the non visited islands

        int islands = 0;
        Set<String> visitedIslands = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(!visitedIslands.contains(i+"->"+j) && grid[i][j] == 1){
                    makeIsland(grid,i,j,visitedIslands);
                    islands++;
                }
            }
        }
        return islands;
    }
    // void bfs to check whole island
    void makeIsland(char[][] grid, int sr, int sc,Set<String> visited){
        //make a queue to run the bfs
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            for (int i = 0; i < xDirections.length; i++) {
                int x= currentX + xDirections[i];
                int y= currentY + yDirections[i];
                if(x >= 0 && x < grid.length && y >= 0 && y< grid[0].length && grid[x][y] == '1' && !visited.contains(x+"->"+y)){
                    visited.add(x+"->"+y);
                    queue.add(new int[]{x,y});
                }
            }
        }
    }
}
