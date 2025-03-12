package AmazonInterview.Graph.DFS;

public class WordSearch {
    // Directions: Up, Right, Down, Left
    int[] xDirections = new int[]{-1, 0, 1, 0};
    int[] yDirections = new int[]{0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;

        // Traverse the board to find the starting character
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Start DFS only if the first character matches
                if (board[i][j] == word.charAt(0) && searchWord(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, String word, int i, int j, int index) {
        // Base case: If we have found the whole word
        if (index == word.length()) return true;

        // Boundary conditions
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited (Backtracking)
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore all four directions
        for (int k = 0; k < 4; k++) {
            int x = i + xDirections[k];
            int y = j + yDirections[k];

            if (searchWord(board, word, x, y, index + 1)) {
                return true;
            }
        }

        // Undo marking (Backtracking)
        board[i][j] = temp;
        return false;
    }
}
