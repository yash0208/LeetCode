package AmazonInterview.PreviousQuestions;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LengthOfTheLongestValidSubstring {
    public int longestValidSubstring(String word, List<String> forbidden) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        char[] chars = word.toCharArray();
        Set<String> set = new HashSet<>(forbidden);
        for (int j = 0; j < chars.length; j++) {
            for (int k = Math.max(i,j-9); k <=j ; k++) {
                if(set.contains(word.substring(k,j))) {
                    i++;
                    break;
                }
            }
            max = Math.max(max,j - i + 1);
        }
        return max;
    }
    boolean isValid(String string,List<String> forbidden){
        for(String s:forbidden){
            if(string.contains(s)) return false;
        }
        return true;
    }
}
