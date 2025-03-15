package AmazonInterview.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutations {
    void permutations(String s, int index, List<String> permutations, StringBuilder characters) {
        if (index == s.length()) {
            permutations.add(characters.toString());
            return;
        }

        // Include current character in the permutation
        characters.append(s.charAt(index));
        permutations(s, index + 1, permutations, characters);

        // Exclude current character from the permutation (backtrack)
        characters.deleteCharAt(characters.length() - 1);
        permutations(s, index + 1, permutations, characters);
    }
    public boolean checkInclusion(String s1, String s2) {
        List<String> possiblePermutations = new ArrayList<>();
        permutations(s1,0,possiblePermutations,new StringBuilder());
        for(String s : possiblePermutations) if(s2.contains(s)) return true;
        return false;
    }
}
