package AmazonInterview.LastMinuteRead;
import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Making a map to map the items with its anagram
        HashMap<String,List<String>> anagramMap = new HashMap<>();
        for(String s: strs){
            char[] mainStringChars = s.toCharArray();
            Arrays.sort(mainStringChars);
            String sorted = new String(mainStringChars);
            anagramMap.computeIfAbsent(sorted,k->new ArrayList<>()).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : anagramMap.entrySet()){
            List<String> currentAnagram = new ArrayList<>();
            for(String anagram : entry.getValue()){
                currentAnagram.add(anagram);
            }
            ans.add(currentAnagram);
        }
        return ans;
    }
}
