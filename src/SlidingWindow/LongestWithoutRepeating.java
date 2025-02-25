package SlidingWindow;

import java.util.HashSet;

public class LongestWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;

        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();

        int j = 0;
        int currentLen = 0 ;
        while (j<chars.length){
            if(set.contains(j)){
                ans = Math.max(ans,currentLen);
                j++;
                currentLen = 0;
                set = new HashSet<>();
            }else{
                set.add(chars[j]);
                currentLen ++;
                j++;
            }
        }

        return ans;
    }
}
