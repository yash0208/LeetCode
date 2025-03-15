package AmazonInterview.LastMinuteRead;

public class WordSearch {
    //Directions
    int[] xDirections = new int[]{-1,0,1,0};
    int[] yDirections = new int[]{0,1,0,-1};
    public boolean exist(char[][] board, String word) {
        for(int i = 0 ;i < board.length ; i++){
            for(int j =0;j<board[i].length;j++){
                if( findWord(board,i,j,word)) return true;
            }
        }
        return false;
    }

    //we will need a dfs function to search the word from perticular index
    boolean findWord(char[][] board, int sr,int sc, String word){
        if(word.length() == 0) return true;
        if(sr >= board.length || sc < 0 || sc >= board[0].length || sr < 0 || board[sr][sc] != word.charAt(0)) return false;
        // If the first char matches we will start our search
        char temp = board[sr][sc];
        board[sr][sc] = '#';
        for(int i = 0; i<yDirections.length;i++){
            int x = sr + xDirections[i];
            int y = sc + yDirections[i];
            if(findWord(board,x,y,word.substring(1))) return true;

        }
        board[sr][sc] = temp;
        return false;
    }
}
