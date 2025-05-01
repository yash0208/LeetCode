/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    //directions
    int[] xDirections = new int[]{0,1,0,-1};
    int[] yDirections = new int[]{1,0,-1,0};

    public int[][] updateMatrix(int[][] mat) {
        int[][] ansMatrix =  new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0) ansMatrix[i][j] = 0;
                else ansMatrix[i][j] = distanceFinder(ansMatrix, i, j);
            }
        }
        return ansMatrix;
    }
    public int distanceFinder(int[][] mat, int row, int column){
        int distace = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row,column});
        Set<String> visiSet = new HashSet<>();
        visiSet.add(row+"->"+column);
        while (!queue.isEmpty()) {
            int size = queue.size();
            distace++;
            for(int i = 0; i < size; i++){
                int[] current = queue.poll();
                int currentX = current[0];
                int currentY = current[1];
                for (int j = 0; j < xDirections.length; j++) {
                    int x = currentX +  xDirections[i];
                    int y = currentY + yDirections[i];
                    if(x >= 0 && x< mat.length && y>=0 && y< mat[0].length && !visiSet.contains(x+"->"+y)){
                        if (mat[x][y] ==0) return distace;
                        else {
                            queue.add(new int[]{x,y});
                            visiSet.add(x+"->"+y);
                        }
                    }
                }
            }
        }
        return -1;
    }
}108 
// @lc code=end

