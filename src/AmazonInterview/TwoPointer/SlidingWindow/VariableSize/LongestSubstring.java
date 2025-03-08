package AmazonInterview.TwoPointer.SlidingWindow.VariableSize;

import java.util.HashSet;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int j = 0;
        int ans = 0;
        while (j < chars.length){
            while (set.contains(chars[j])){
                set.remove(chars[i]);
                i++;
            }
            set.add(chars[j]);
            j++;
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
