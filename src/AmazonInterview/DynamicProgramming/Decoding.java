package AmazonInterview.DynamicProgramming;

public class Decoding {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0; // Edge case: String starts with '0' or is empty
        }

        int len = s.length();
        int[] count = new int[len + 1];
        count[len] = 1; // Base case: There's one way to decode an empty string
        count[len - 1] = s.charAt(len - 1) != '0' ? 1 : 0; // Base case for the last character

        for (int i = len - 2; i >= 0; i--) {
            if (isValid(s.charAt(i))) {
                count[i] += count[i + 1]; // Single character decode
            }
            if (isValid(s.charAt(i), s.charAt(i + 1))) {
                count[i] += count[i + 2]; // Double character decode
            }
        }
        return count[0];
    }

    boolean isValid(char c) {
        return c != '0'; // A single digit can only be valid if it's not '0'
    }

    boolean isValid(char c1, char c2) {
        return (c1 == '1') || (c1 == '2' && c2 <= '6'); // Valid two-character combination
    }
}
