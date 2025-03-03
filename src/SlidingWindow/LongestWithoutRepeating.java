package SlidingWindow;

import java.util.HashSet;

public class LongestWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
       int i = 0;
       char[] chars = s.toCharArray();
       int ans = Integer.MIN_VALUE;
       int j =1;
       while(j < chars.length) {
            if( chars[i] == chars[j]) {
                ans = Math.max(ans, Math.abs(i - j ));
                i++;
            }
            else{
                j++;
            }
        }
       return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}
