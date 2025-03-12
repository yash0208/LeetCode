package AmazonInterview.Graph.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfIslands {
    int[] xDirections =  {-1,0,1,0};
    int[] yDirections = {0,1,0,-1};
    public int numIslands(char[][] grid) {
        int width = grid[0].length;
        int height = grid.length;
        int islands = 0;
        Set<String> vistedSet = new HashSet<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(grid[i][j] != '0' && !vistedSet.contains(i+","+j)){
                    vistedSet.add(i+","+j);
                    bfs(grid,vistedSet,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }

    void bfs(char[][] grid,Set<String> visited, int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c});
        while (!queue.isEmpty()){
            int size  = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int xCurrent = node[0];
                int yCurrent = node[1];
                for (int j = 0; j < xDirections.length; j++) {
                    int x = xCurrent + xDirections[j];
                    int y = yCurrent + yDirections[j];
                    if(x>=0 && y>= 0 && x<grid.length && y<grid[x].length && grid[x][y]!='0' && !visited.contains(x+","+y)){
                        queue.add(new int[]{x,y});
                        visited.add(x+","+y);
                    }
                }
            }
        }
    }
}
