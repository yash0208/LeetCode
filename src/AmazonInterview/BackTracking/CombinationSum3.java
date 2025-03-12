package AmazonInterview.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(k,n,1,ans,new ArrayList<>());
        return ans;
    }
    void backtrack(int k, int remain, int start, List<List<Integer>> ans, List<Integer> tempAns){
        if(remain == 0 && tempAns.size() == k) {
            ans.add(new ArrayList<>(tempAns)); // Fix: Add a copy of tempAns
            return;
        }
        if (remain < 0 || tempAns.size() > k) { // Prune unnecessary calls
            return;
        }
        for (int i = start; i < 10; i++) {
            tempAns.add(i);
            backtrack(k,remain - i,i+1,ans,tempAns);
            tempAns.remove(tempAns.size() - 1);

        }
    }
}
