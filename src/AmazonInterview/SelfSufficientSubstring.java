package AmazonInterview;

public class SelfSufficientSubstring {

    public static void main(String[] args) {
        String testString = "hegekmfhbexwtzsuzs";
        String result = findLongestLength(testString);
        System.out.println(result);  // Should print the longest self-sufficient substring and its length
    }

    public static String findLongestLength(String fullString) {
        // Check if the string is null or empty
        if (fullString == null || fullString.isEmpty()) {
            return "0"; // Edge case
        }

        // Initialize variables
        int n = fullString.length();
        int maxLength = 0;
        String longestSubstring = "";

        // Arrays to keep track of the first and last occurrences of each character
        int[] firstOccurrence = new int[26];
        int[] lastOccurrence = new int[26];

        // Initialize the arrays with -1
        for (int i = 0; i < 26; i++) {
            firstOccurrence[i] = -1;
            lastOccurrence[i] = -1;
        }

        // Record first and last occurrences of each character
        for (int i = 0; i < n; i++) {
            int charIndex = fullString.charAt(i) - 'a';
            if (firstOccurrence[charIndex] == -1) {
                firstOccurrence[charIndex] = i;
            }
            lastOccurrence[charIndex] = i;
        }

        // Check each position as a potential start of a substring
        for (int i = 0; i < n - 1; i++) {  // We ensure it's a proper substring by iterating only up to n-1
            int possibleEnd = n - 1; // Start with the maximum possible end
            boolean isValid = true; // Flag to check if the substring is valid

            // Iterate from the current start position to possible end
            for (int j = i; j <= possibleEnd; j++) {
                int currentChar = fullString.charAt(j) - 'a';

                // Check if the current character's first or last occurrence violates the range
                if (firstOccurrence[currentChar] < i || lastOccurrence[currentChar] > possibleEnd) {
                    possibleEnd = Math.min(possibleEnd, lastOccurrence[currentChar] - 1); // Shrink the window
                    if (possibleEnd < j) {
                        isValid = false;
                        break;
                    }
                }
            }

            // Update the maximum length and longestSubstring if a valid substring is found
            int currentLength = possibleEnd - i + 1;
            if (isValid && currentLength > maxLength && currentLength < n) { // Ensure it's a proper substring
                maxLength = currentLength;
                longestSubstring = fullString.substring(i, possibleEnd + 1);
            }
        }

        return "Longest self-sufficient proper substring: \"" + longestSubstring + "\", Length: " + maxLength;
    }
}
