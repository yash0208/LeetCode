package Math;

public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        int count = 0;
        while ( n > 0 ){
            if(isUgly(n)) count++;
            n--;
        }
        return count;
    }
    boolean isUgly(int n){
        if (n==0) return false;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }
}
