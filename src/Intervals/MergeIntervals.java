package Intervals;

import java.util.Arrays;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort intervals based on start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[][] result = new int[intervals.length][2];
        int index = 0;
        result[index] = intervals[0];  // Initialize with the first interval

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] lastMerged = result[index];

            if (current[0] <= lastMerged[1]) { // Overlapping intervals
                lastMerged[1] = Math.max(lastMerged[1], current[1]);
            } else { // No overlap, move to the next interval
                index++;
                result[index] = current;
            }
        }

        return Arrays.copyOf(result, index + 1);
    }
}
