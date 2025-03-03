package SlidingWindow;

public class KBeauty {
    public int divisorSubstrings(int num, int k) {
        String n = String.valueOf(num);
        int i = 0;
        int j = i + k - 1;
        int ans = 0;
        if (isDivisible(n.substring(i,j))) ans++;
        i++;
        j++;
        while (j < n.length()){
            if (isDivisible(n.substring(i,j))) ans++;
            i++;
            j++;
        }
        return ans;
    }
    boolean isDivisible(String num){
        int n = Integer.parseInt(num);
        return n%2 == 0;
    }
}
