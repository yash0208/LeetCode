package Greedy;

public class maxDistance {
    public int maxDistance(int[] colors) {
        int ans = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                if(colors[i] != colors[j]){
                    ans = Math.max(ans, Math.abs( i - j) );
                }
            }
        }
        return ans;
    }
    public int maxDistanceGreedy(int[] colors) {
        int n = colors.length;
        int maxDist = 0;

        // Compare with the first house
        for (int j = n - 1; j > 0; j--) {
            if (colors[j] != colors[0]) {
                maxDist = Math.max(maxDist, j);
                break;
            }
        }

        // Compare with the last house
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                maxDist = Math.max(maxDist, n - 1 - i);
                break;
            }
        }

        return maxDist;
    }
}
