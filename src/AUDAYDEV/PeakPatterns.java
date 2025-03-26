package AUDAYDEV;

import java.util.*;

public class PeakPatterns {
    public static String canRecordSequence(int n, int[] sequence) {
        Stack<Integer> stack = new Stack<>();
        int currentPeak = 0;

        for (int peak : sequence) {

            // Sight new peaks until we reach the current one in sequence
            while (currentPeak <= peak) {
                stack.push(currentPeak);
                currentPeak++;
            }

            // Check if the peak to record is at the top of the stack
            if (!stack.isEmpty() && stack.peek() == peak) {
                stack.pop();
            } else {
                return "No";
            }
        }

        return "Yes";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sequence = new int[n];

        for (int i = 0; i < n; i++) {
            sequence[i] = scanner.nextInt();
        }
        scanner.close();

        // Additional edge case check
        int maxPeak = Arrays.stream(sequence).max().orElse(-1);
        if (maxPeak >= n) {
            System.out.println("No");
        } else {
            System.out.println(canRecordSequence(n, sequence));
        }
    }
}
