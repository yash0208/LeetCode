package AmazonInterview.BinarySearch;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length;
        int n = matrix.length;
        int left = 0;
        int right = m * n -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            int i = mid / m;
            int j = mid % m;
            if(matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}
