package AmazonInterview.BinarySearch;

import java.util.Arrays;

public class SuccessPairs {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int l = 0;
            int r = potions.length - 1;
            while (l < r){
                int mid = l + (r - l) / 2;
                if(success >= (spells[i]*potions[mid])) l = mid + 1;
                if(success <= (spells[i]*potions[mid])) r = mid - 1;
            }
            ans[i] = potions.length - l;
        }
        return ans;
    }
    public int[] successfulPairs2(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];
        int max = 0;
        for (int i=0;i<m;i++){
            max = Math.max(max, potions[i]);
        }
        int[] map = new int[max+1];
        for (int i=0;i<m;i++){map[potions[i]]++;}
        int sum=0;
        for (int i=max;i>=0;i--){
            sum += map[i];
            map[i] = sum;
        }
        for (int i=0;i<n;i++){
            int spell = spells[i];
            long index = (success+spell-1)/spell;
            if (index<=max){
                res[i]=map[(int) index];
            }
        }

        return res;
    }
}
