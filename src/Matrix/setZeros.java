package Matrix;

public class setZeros {
    public void setZeroes(int[][] matrix) {
        int c = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    for (int k = 0; k < matrix[i].length; k++) {
                        if(matrix[i][k] !=0){
                            matrix[i][k] = c;
                        }
                    }
                    for (int k = 0; k < matrix.length; k++) {
                        if(matrix[k][j] != 0){
                            matrix[k][j] = c;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == c) matrix[i][j] = 0;
            }
        }
    }
}
