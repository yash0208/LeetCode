package AmazonInterview.PreviousQuestions;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> temp, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(temp)); // Found a valid combination
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target >= candidates[i]) { // Only proceed if candidate is <= target
                temp.add(candidates[i]);  // Choose element
                backtrack(candidates, target - candidates[i], i, temp, result); // Continue with the same index
                temp.remove(temp.size() - 1); // Undo choice (Backtrack)
            }
        }
    }
}
