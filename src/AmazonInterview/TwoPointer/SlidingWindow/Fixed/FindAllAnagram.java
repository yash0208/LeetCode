package AmazonInterview.TwoPointer.SlidingWindow.Fixed;

import java.util.*;

public class FindAllAnagram {

    public  boolean isAnagram(String s, String p){
        int[] chars = new int[26];
        for(char c : p.toCharArray()) chars[c - 'a']++;
        for(char c : s.toCharArray()) chars[c - 'a']--;
        for(int count : chars){
            if (count != 0) return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = i + p.length() - 1;
        while (j < s.length()){
            if(isAnagram(s.substring(i,j + 1),p)) ans.add(i);
            i++;
            j++;
        }
        return ans;
    }

}
