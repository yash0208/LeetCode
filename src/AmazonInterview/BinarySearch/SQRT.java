package AmazonInterview.BinarySearch;

public class SQRT {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right){
            double mid = left + (right - left) / 2;
            if (Math.pow(mid,2) == x){
                return (int) mid;
            } else if (Math.pow(mid,2) < x) {
                left = (int) mid + 1;
            }
            else {
                right = (int) mid - 1;
            }
        }
        return right;
    }
}
