package Matrix;

import java.util.HashSet;

public class validSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
            if (!checkRow(board[i])) return false;

        }
        for (int i = 0; i < board.length; i++) {
            if (!checkColumn(board, i)) return false;
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkCube(board, i, j)) return false;
            }
        }
        return true;
    }
    boolean checkRow(char[] row){
        HashSet<Character> set = new HashSet<>();
        for (char c: row){
            if(c != '.'){
                if(set.contains(c)) return false;
                else set.add(c);
            }
        }
        return true;
    }
    boolean checkColumn(char[][] board, int column){
        HashSet<Character> set = new HashSet<>();
        for(int i = 0 ; i < board.length;i++){
            char c = board[i][column];
            if(c != '.'){
                if(set.contains(c)) return false;
                else set.add(c);
            }
        }
        return true;
    }
    boolean checkCube(char[][] board, int row, int col) {
        HashSet<Character> set = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) return false;
                    set.add(c);
                }
            }
        }
        return true;
    }

}
