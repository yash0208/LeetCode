package AmazonInterview.Heap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString {
    public String reorganizeString(String s) {
        // Step 1: Count character frequencies
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Use a max heap (priority queue) to store characters by frequency
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue() // Sort by highest frequency first
        );
        queue.addAll(map.entrySet());

        // Step 3: Check if it's possible to reorganize the string
        int maxFreq = queue.peek().getValue();
        if (maxFreq > (s.length() + 1) / 2) return "";

        // Step 4: Fill the result array
        char[] result = new char[s.length()];
        int index = 0;

        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            char ch = entry.getKey();
            int freq = entry.getValue();

            // Place the character `freq` times in alternate positions
            for (int i = 0; i < freq; i++) {
                if (index >= s.length()) {
                    index = 1; // Move to the next available odd index
                }
                result[index] = ch;
                index += 2;
            }
        }

        return new String(result);
    }
}
