package AmazonInterview.LastMinuteRead;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    //Directions
    int[] xDirections = new int[]{-1,0,1,0};
    int[] yDirections = new int[]{0,1,0,-1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //Here we need to fill all the values starting from the source with the color desired
        int sourceColor = image[sr][sc];
        if (sourceColor == color) return image;
        colorFill(image,sr,sc,color,sourceColor);
        return image;
    }
    //BFS function to traverse to the nearby values
    void colorFill(int[][] image,int sr,int sc,int color,int sourceColor){
        //Making a queue to add the current node and start bfs
        Queue<int[]> positionQueue = new LinkedList<>();
        positionQueue.add(new int[]{sr,sc});
        while (!positionQueue.isEmpty()){
            int[] currentPosition = positionQueue.poll();
            int currentX = currentPosition[0];
            int currentY = currentPosition[1];
            image[currentX][currentY] = color;
            for(int i = 0; i<xDirections.length;i++){
                int x = currentX + xDirections[i];
                int y = currentY + yDirections[i];
                if(x>=0 && x< image.length && y>=0 && y<image[0].length && image[x][y] == sourceColor){
                    positionQueue.add(new int[]{x,y});
                }
            }
        }
    }
}
