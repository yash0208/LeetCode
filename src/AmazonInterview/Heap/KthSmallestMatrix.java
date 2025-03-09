package AmazonInterview.Heap;

import java.util.PriorityQueue;

public class KthSmallestMatrix {
    //Bruit force
    public int kthSmallest(int[][] matrix, int k) {
        int l = matrix[0][0];
        int r = matrix[matrix.length -1][matrix.length -1];
        while (l < r){
            int mid = l + (r - l) / 2;
            if (count(matrix,mid) < k) l = mid + 1;
            else r = mid;
        }
        return l;
    }
    int count(int[][] matrix,int val){
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            count = count + upperBound(matrix[i],val);
        }
        return count;
    }
    int upperBound(int[] arr, int val) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= val) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
