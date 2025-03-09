package AmazonInterview.Heap;

public class UglyNumber {
    public boolean isUgly(int n) {
        int[] factors = new int[]{2,3,5};
        for (int factor : factors){
            while (n%factor == 0){
                n /= factor;
            }
        }
        return n == 1;
    }
}
