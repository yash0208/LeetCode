package AmazonInterview.TwoPointer.SlidingWindow.VariableSize;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] arr = new int[128]; // Supports all ASCII characters
        for (char c : t.toCharArray()) arr[c]++; // Store frequency of t's characters

        int i = 0, start = 0, minLen = Integer.MAX_VALUE;
        int count = t.length(); // Number of characters needed to be matched
        char[] chars = s.toCharArray();

        for (int j = 0; j < chars.length; j++) {
            char c = chars[j];
            if (arr[c] > 0) count--; // Required character found
            arr[c]--; // Reduce the count in the map

            while (count == 0) { // When all characters are matched
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }
                char c2 = chars[i];
                arr[c2]++; // Restore the count
                if (arr[c2] > 0) count++; // If removing makes a required character missing
                i++; // Shrink the window
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

}
