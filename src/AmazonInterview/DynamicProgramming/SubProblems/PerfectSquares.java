package AmazonInterview.DynamicProgramming.SubProblems;

public class PerfectSquares {
    public int numSquares(int n) {
        return findFits(1,0,0,n);
    }

    public int findFits(int n,int currentSum,int currentCount,int target){
        if(currentSum > target) return Integer.MAX_VALUE;
        if(currentSum == target) return currentCount;
        if(isPerfectSquare(n)) {
            return Math.min(findFits(n+1,currentSum - n,currentCount+1,target),findFits(n+1,currentSum,currentCount,target));
        }
        else return findFits(n+1,currentSum,currentCount,target);
    }

    public boolean isPerfectSquare(int n){
        int i = (int) Math.sqrt(n);
        int square = i * i;
        return square == n;
    }
}
