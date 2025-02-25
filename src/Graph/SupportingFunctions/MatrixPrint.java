package Graph.SupportingFunctions;

public class MatrixPrint {
    public void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Print column indexes
        System.out.print("    ");
        for (int col = 0; col < cols; col++) {
            System.out.printf("  %2d ", col);
        }
        System.out.println();

        // Print top border
        System.out.print("   ");
        printLine(cols);

        // Print each row with row index
        for (int row = 0; row < rows; row++) {
            System.out.printf("%2d | ", row); // Row index
            for (int col = 0; col < cols; col++) {
                System.out.printf("%2d | ", matrix[row][col]);
            }
            System.out.println();
            System.out.print("   ");
            printLine(cols); // Print separator line after each row
        }
    }

    // Helper function to print a line separator
    private void printLine(int cols) {
        System.out.print("+");
        for (int i = 0; i < cols; i++) {
            System.out.print("----+");
        }
        System.out.println();
    }
}
