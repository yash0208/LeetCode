import java.util.LinkedList;
import java.util.Queue;

class Solution {
    //Directions
    int[] xDirections = new int[]{-1,0,1,0};
    int[] yDirections = new int[]{0,1,0,-1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //Start from the sourceNode
        int sourceNodeColor = image[sr][sc];
        bfs(image,sr,sc,color,sourceNodeColor);
        return image;

    }

    //Run bfs over the nearby nodes to change colors of them
    public void bfs(int[][] image, int sr,int sc,int color,int sourceColor){
        //Queue to iterate through the bfs nodes
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for(int i = 0;i<xDirections.length;i++){
                int currentX = x + xDirections[i];
                int currentY = y + yDirections[i];
                if(x>=0 && x<image.length && y>=0 && y<image[0].length && image[x][y] == sourceColor){
                    image[x][y] = color;
                    queue.add(new int[]{x,y});
                }
            }
        }
    }
}
