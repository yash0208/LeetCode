package AmazonInterview.PreviousQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        if(candidates.length == 0) return list;
        for (int i : candidates){
            int sum = i;
            List<Integer> level = new ArrayList<>();
            boolean flag = true;
            while (sum > target) {
                if(set.contains(target - sum)) {
                    level.add(target - sum);
                }
                else flag = false;
            }
            if(flag && sum == target) list.add(level);
        }
        return list;
    }
}
